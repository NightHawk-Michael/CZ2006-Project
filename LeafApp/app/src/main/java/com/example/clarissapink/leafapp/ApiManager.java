package com.example.clarissapink.leafapp;

import android.os.AsyncTask;

import com.example.clarissapink.leafapp.models.HDBFlat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//This Class will retrieve data from the government API.
public class ApiManager {
    private DatabaseHandler db;

    public ApiManager( DatabaseHandler db){
        this.db = db;
    }

    public void getApiData() {
        new JSONTask().execute("https://data.gov.sg/api/action/datastore_search?resource_id=d23b9636-5812-4b33-951e-b209de710dd5&limit=200");
    }

    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONObject resultObject = parentObject.getJSONObject("result");
                JSONArray parentArray = resultObject.getJSONArray("records");

                // if there is a connection, create entity classes from data and insert into database
                //if (connected == true) {
                    List<HDBFlat> HdbList = new ArrayList();

                    for (int i = 0; i < parentArray.length(); i++) {
                        JSONObject finalObject = parentArray.getJSONObject(i);

                        int id = Integer.parseInt(finalObject.getString("_id"));
                        int year = Integer.parseInt(finalObject.getString("financial_year"));
                        String town = finalObject.getString("town");
                        String roomtype = finalObject.getString("room_type");
                        String minprice = finalObject.getString("min_selling_price");
                        String maxprice = finalObject.getString("max_selling_price");
                        String minprice_less = finalObject.getString("min_selling_price_less_ahg_shg");
                        String maxprice_less = finalObject.getString("max_selling_price_less_ahg_shg");

                        HDBFlat hdb = new HDBFlat(id, year, town, roomtype, minprice, maxprice, minprice_less, maxprice_less);
                        HdbList.add(hdb);
                        db.addHDB(hdb);


                    }
                //}

                //else we should be taking data from database to initialise objects

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //hdbData.setText(result.toString());
        }
    }
}

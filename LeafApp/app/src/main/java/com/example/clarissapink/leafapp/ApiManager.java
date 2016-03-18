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

/**
 * This class will manage the gov data API
 * @author Bryant
 */
public class ApiManager {

    /**
     * Declaration of a DatabaseHandler to be used later
     */
    private DatabaseHandler db;

    /**
     * Creates a new ApiManager object for the given database
     * @param db  The database where the data from the API will be inserted to
     */
    public ApiManager( DatabaseHandler db){
        this.db = db;
    }

    /**
     * This method will execute the http call.
     */
    public void getApiData() {
        new JSONTask().execute("https://data.gov.sg/api/action/datastore_search?resource_id=d23b9636-5812-4b33-951e-b209de710dd5&limit=200");
    }

    /**
     * This class that extends AsyncTask allows the application to conduct Asynchronous Tasks at the "backend" of the app.
     * This will allow the http call and the insertion to the database to be done without disruption to the UI
     */
    public class JSONTask extends AsyncTask<String, String, String> {

        /**
         * This method is one of the steps to an AsyncTask
         * When invoked, it allows the application to perform background computation that takes a long time
         * The parameters, params which in this case is the URL of the HttpCall, also known as the URL of our API is passed
         * The result of this method is passed to the last step, which is onPostExecute()
         * @param params  The URL of the HTTPCall
         * @return  We will not be returning a value for now.
         */
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

        /**
         * This method will be invoked on the UI thread after background computation finishes
         * @param result  This is the result from the background computation.
         */
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //hdbData.setText(result.toString());
        }
    }
}

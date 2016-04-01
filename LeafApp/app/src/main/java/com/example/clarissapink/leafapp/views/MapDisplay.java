package com.example.clarissapink.leafapp.views;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clarissapink.leafapp.EventHandler.EventHandler;
import com.example.clarissapink.leafapp.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.vision.barcode.Barcode;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * This class will manage the map displayed on the app
 * @author Emily
 */
public class MapDisplay extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        OnMapReadyCallback,
        LocationListener {
    private EventHandler eventHandler;
    private String flatLocation = null;
    private String town = null;
    private double flatLong;
    private double flatLat;
    /**
     * Creates a TAG to get where the Map is located at
     */
    public static final String TAG = MapDisplay.class.getSimpleName();

    /**
     * Define a request code to send to Google Play services upon failure
     * This code is returned in Activity.onActivityResult
     */
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    /**
     * Declaration of a GoogleMap, might be null if Google Play services APK is not available.
     */
    private GoogleMap mMap;

    /**
     * Declaration of a GoogleAPIClient to get the latest client in Google Play Services
     */
    private GoogleApiClient mGoogleApiClient;

    /**
     * Declaration of a LocationRequest to get the details of user's location
     */
    private LocationRequest mLocationRequest;

    /**
     * This method will save the state of the application in a bundle
     * @param savedInstanceState save state created previously
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_display);
        flatLocation = getIntent().getExtras().getString("location");
        town = getIntent().getExtras().getString("town");
        Bundle mapDisplay = getIntent().getExtras();
        eventHandler = mapDisplay.getParcelable("eventHandler");
        TextView chosenLocation = (TextView) findViewById(R.id.textView14);
        chosenLocation.setText(town);
        try {
            Address add = this.getCoordinates(flatLocation);
            this.flatLat = add.getLatitude();
            this.flatLong = add.getLongitude();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUpMapIfNeeded();
        /**
         * Create the GoogleApiClient object
         */
        // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(AppIndex.API).build();

        /**
         * Create the LocationRequest object
         */
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

    }

    /**
     * Generate Coordinates of the flat Location.
     * @param flatLocation
     * @return
     * @throws IOException
     */
    private Address getCoordinates(String flatLocation) throws IOException {
        Geocoder geocoder = new Geocoder(this);
        String locationName = flatLocation.concat(", Singapore");
        List<Address> addresslist = geocoder.getFromLocationName(locationName,1);
//        Random rand = new Random();
//        int randNumber = rand.nextInt(addresslist.size());
        Address flatAddress = addresslist.get(0);
        //String locality = flatAddress.getSubLocality();
        Toast.makeText(this, flatLocation, Toast.LENGTH_LONG).show();
        return flatAddress;
    }

    /**
     * This method disconnect from location services when Activity is paused
     * It reconnects when the Activity is resumed
     */
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }

    /**
     * This method disconnect from location services when Activity is paused
     */
    protected void onPause() {
        super.onPause();

        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    /**
     * This method sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated..
     */
    private void setUpMapIfNeeded() {
        if (mMap == null) {
            SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
                    mapFragment.getMapAsync(this);
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
    }

    /**
     * This method is where set up map according to a default location
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    /**
     * This method handles new location
     */
    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());

        double currentLatitude = this.flatLat; //location.getLatitude();
        double currentLongitude = this.flatLong; //location.getLongitude();

        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title(this.flatLocation);

        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    /**
     * This method gets current location when the client successfully connected to the location services
     * @param bundle saves the dynamic data of location
     */
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        else {
            handleNewLocation(location);
        }
    }

    /**
     * This method suspends the connection
     * @param i contains variable to suspend the connection
     */
    public void onConnectionSuspended(int i) {

    }

    /**
     * This method handles connection failure
     * @param connectionResult gets connection result
     */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    /**
     * This new method gets called every time a new location is detected by Google Play Services
     * It calls handleNewLocation to get to the new location
     * @param location stores the new location detected
     */
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }

    /**
     * This method navigates to FlatAvailableResults
     * @param view stores what the user interact with the button
     */
    public void btn1(View view) {
        Intent intent = new Intent(this, FlatAvailableView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to AffordableFlatView
     * @param view stores what the user interact with the button
     */
    public void btn2(View view) {
        Intent intent = new Intent(this, AffordableFlatView.class);
        intent.putExtra("eventHandler", eventHandler);

        startActivity(intent);
    }

    /**
     * This method navigates to ApplicableGrantView
     * @param view stores what the user interact with the button
     */
    public void btn3(View view) {
        Intent intent = new Intent(this, ApplicableGrantView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

    /**
     * This method navigates to DebtRepaymentView
     * @param view stores what the user interact with the button
     */
    public void btn4(View view) {
        Intent intent = new Intent(this, DebtRepaymentView.class);
        intent.putExtra("eventHandler", eventHandler);
        startActivity(intent);
    }

}
package com.example.clarissapink.leafapp.views;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.clarissapink.leafapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * This class will manage the map displayed on the app
 * @author Emily
 */
public class MapDisplay extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    private String flatLocation = null;
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
        setUpMapIfNeeded();

        /**
         * Create the GoogleApiClient object
         */
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        /**
         * Create the LocationRequest object
         */
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

        flatLocation = getIntent().getExtras().getString("location");
        TextView chosenLocation = (TextView) findViewById(R.id.textView14);
        chosenLocation.setText(flatLocation);
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
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setUpMap();
            }
        }
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

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();

        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("I am here!");

        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
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
}
package com.example.kbvora.arihant1;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getloc();
        setUpMapIfNeeded();
        getdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    double lati=0,longi=0;
    Location l=null;
    private void getloc() {

        LocationManager lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> providers=lm.getProviders(true);

        for(int i=providers.size()-1;i>=0;i--)
        {
            l=lm.getLastKnownLocation(providers.get(i));
            if(l!=null)
                break;
        }
        if(l!=null)
        {
            lati=l.getLatitude();
            longi=l.getLongitude();
        }

    }
    void getdata()
    {

        AsyncHttpClient mClient=new AsyncHttpClient();
        mClient.get(MapsActivity.this,"https://maps.googleapis.com/maps/api/place/search/json?location=23.0395677,72.5660044&radius=5000000&name=jain tirth&key=AIzaSyDWpgQxAFzsD1DnDGEGd_vFZDFmK5HucIw",new JsonHttpResponseHandler(){

            ProgressDialog mProgressDialog;
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                ArrayList<String> na;
                double[] lat;
                double[] lon;

                na=new ArrayList<String>();
                double x=0,y=0;
                try {
                    JSONArray mJsonArray=response.getJSONArray("results");
                    lat=new double[mJsonArray.length()];
                    lon=new double[mJsonArray.length()];
                    JSONObject mJsonObject;
                    for(int i=0;i<mJsonArray.length();i++)
                    {
                        mJsonObject=mJsonArray.getJSONObject(i);

                        JSONObject m1=mJsonObject.getJSONObject("geometry");
                        JSONObject m2=m1.getJSONObject("location");
                        lat[i]= m2.getDouble("lat");
                        lon[i]=m2.getDouble("lng");
                        na.add(mJsonObject.getString("name"));

                    }
                    for(int i=0;i<na.size();i++) {
                        mMap.addMarker(new MarkerOptions().position(new LatLng(lat[i],lon[i])).title(na.get(i).toString()));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onStart() {
                super.onStart();
                mProgressDialog= ProgressDialog.show(MapsActivity.this, "Loding ", "Please Wait");
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if(mProgressDialog.isShowing())
                {
                    mProgressDialog.dismiss();
                }
            }
        });
    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(lati, longi)).title("Marker"));
        CameraPosition camPos = new CameraPosition.Builder()
                .target(new LatLng(lati, longi))
                .zoom(18)
                .bearing(l.getBearing())
                .tilt(90)
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        mMap.animateCamera(camUpd3);
    }
}

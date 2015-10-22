package com.example.smallbirdking.seriess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;

/**
 * Created by smallbirdking on 2015/10/15.
 */
public class getLocation extends Activity {
    private EditText editText;
    private LocationManager lm;
    private static final String TAG="GpsActivity";
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        lm.removeUpdates(locationListener);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        editText=(EditText)findViewById(R.id.editText);
        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

        //check if GPS is opened
        if(!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Toast.makeText(this, "please open GPS...", Toast.LENGTH_SHORT).show();
            //return GPS Ｓetting Page
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent,0);
            return;
        }

        //make search condition to get location
        String bestProvider = lm.getBestProvider(getCriteria(), true);
        //get location infors
        Location location= lm.getLastKnownLocation(bestProvider);
        updateView(location);
        //listening
        lm.addGpsStatusListener(listener);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, locationListener);
    }

    //位置监听
    private LocationListener locationListener=new LocationListener() {

        /**
         * when location changed
         */
        public void onLocationChanged(Location location) {
            updateView(location);
            Log.i(TAG, "time：" + location.getTime());
            Log.i(TAG, "longitude："+location.getLongitude());
            Log.i(TAG, "latitude："+location.getLatitude());
            Log.i(TAG, "sea high level："+location.getAltitude());
        }

        /**
         * GPS location changed
         */
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.i(TAG, "GPS state visible");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.i(TAG, "GPS out of service");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.i(TAG, "GPS service stop");
                    break;
            }
        }

        /**
         * GPS opened
         */
        public void onProviderEnabled(String provider) {
            Location location=lm.getLastKnownLocation(provider);
            updateView(location);
        }

        /**
         * GPS stoped
         */
        public void onProviderDisabled(String provider) {
            updateView(null);
        }


    };

    //start listening
    GpsStatus.Listener listener = new GpsStatus.Listener() {
        public void onGpsStatusChanged(int event) {
            switch (event) {
                case GpsStatus.GPS_EVENT_FIRST_FIX:
                    Log.i(TAG, "first locate");
                    break;
                //GPS state changed
                case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
                    Log.i(TAG, "satellite changed");
                    //get state now
                    GpsStatus gpsStatus=lm.getGpsStatus(null);
                    int maxSatellites = gpsStatus.getMaxSatellites();
                    Iterator<GpsSatellite> iters = gpsStatus.getSatellites().iterator();
                    int count = 0;
                    while (iters.hasNext() && count <= maxSatellites) {
                        GpsSatellite s = iters.next();
                        count++;
                    }
                    System.out.println("searched："+count+"satellites");
                    break;
                case GpsStatus.GPS_EVENT_STARTED:
                    Log.i(TAG, "start locate");
                    break;
                case GpsStatus.GPS_EVENT_STOPPED:
                    Log.i(TAG, "GPS stop");
                    break;
            }
        };
    };

    /**
     *
     * @param location
     */
    private void updateView(Location location){
        if(location!=null){
            editText.setText("locate infors\n\nlongitude：");
            editText.append(String.valueOf(location.getLongitude()));
            editText.append("\nlatitude：");
            editText.append(String.valueOf(location.getLatitude()));
        }else{
            //清空EditText对象
            editText.getEditableText().clear();
        }
    }

    /**
     * @return
     */
    private Criteria getCriteria(){
        Criteria criteria=new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(false);
        criteria.setBearingRequired(false);
        criteria.setAltitudeRequired(false);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return criteria;
    }

}

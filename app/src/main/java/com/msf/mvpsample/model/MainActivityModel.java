package com.msf.mvpsample.model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;;
import com.msf.mvpsample.view.MainActivityContract;

public class MainActivityModel implements MainActivityContract.Model {


    private FusedLocationProviderClient fusedLocationProviderClient;

    Context context;
    private static final int PERMISSION_LOCATION = 0;
    View layout;
    Location mLocation;

    public MainActivityModel(Context context, View layout) {
        this.context = context;
        this.layout = layout;
    }

    public String getData()
    {
        return "This is MVP";
    }






    public String getUpdatedLocation() {

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermission();
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                mLocation= location;




            }
        });

        if(mLocation== null)
        return  ("\n" + "LAt"  + " long" );
        else
            return  ("\n" + "Lat  " + mLocation.getLatitude() + "\n Long  " + mLocation.getLongitude()+"\n Provider  "+mLocation.getProvider()+"\n Altitude  "+mLocation.getAltitude());
    }

    public void requestPermission() {

        Log.d("Main activity model","permission called");

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                Manifest.permission.ACCESS_FINE_LOCATION)) {

            Snackbar.make(layout, "Location access required",
                    Snackbar.LENGTH_INDEFINITE).setAction("Set Permission", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions((Activity) context,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            PERMISSION_LOCATION);
                }
            }).show();


        } else {
            Snackbar.make(layout, "Location Permission unavailable", Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION);
        }
    }


}

package com.msf.mvpsample.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.msf.mvpsample.BuildConfig;
import com.msf.mvpsample.R;
import com.msf.mvpsample.model.MainActivityModel;
import com.msf.mvpsample.presenter.MainActivityPresenter;
import com.msf.mvpsample.view.MainActivityContract;

import static com.msf.mvpsample.view.MainActivityContract.*;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, ActivityCompat.OnRequestPermissionsResultCallback {


    private Presenter presenter;
    TextView textView;
    Button startButton;
    View layout;
    MainActivityModel model;

   // private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.dummy);
        startButton = findViewById(R.id.start);
        layout = findViewById(R.id.root);
        model = new MainActivityModel(this,layout);

        presenter = new MainActivityPresenter(layout,this,this);


    }

    @Override
    public void initView() {




        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClick(v);





               //getUpdatedLocation();

            }
        });


    }



    @Override
    public void setViewData(String displayData) {

        textView.setText(displayData);
        textView.append(("\n " + BuildConfig.APPLICATION_ID));


    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_LOCATION) {
//            // Request for camera permission.
//            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission has been granted. Start camera preview Activity.
//                Snackbar.make(layout, "Permission granted",
//                        Snackbar.LENGTH_SHORT)
//                        .show();
//                getUpdatedLocation();
//            } else {
//                // Permission request was denied.
//                Snackbar.make(layout, "permission denied",
//                        Snackbar.LENGTH_SHORT)
//                        .show();
//            }
//
//
//        }
//    }





//        void getUpdatedLocation () {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                requestPermission();
//            }
//
//
//
//            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
//
//                    textView.append(("\n" + "LAt" + location.getLatitude() + " long" + location.getLongitude()));
//
//
//                }
//            });
//        }
    }


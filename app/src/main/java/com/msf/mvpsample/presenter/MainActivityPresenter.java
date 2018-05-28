package com.msf.mvpsample.presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.msf.mvpsample.view.MainActivityContract;
import com.msf.mvpsample.model.MainActivityModel;

import static com.msf.mvpsample.view.MainActivityContract.*;

public class MainActivityPresenter implements Presenter {

    private MainActivityContract.View mView;
    private Model model;

    View view;
    Context context;

    public MainActivityPresenter(View view, Context context,MainActivityContract.View contractView) {
        this.context = context;
        this.view = view;
        mView =  contractView;
        initPresenter();
    }



    private void initPresenter() {

         model = new MainActivityModel(context,view);
         mView.initView();
    }





    @Override
    public void onClick(View view) {


                mView.setViewData(model.getData());
                 model.requestPermission();
                mView.setViewData(model.getUpdatedLocation());
                model.getUpdatedLocation();

    }


}

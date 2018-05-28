package com.msf.mvpsample;

import android.view.View;

import static com.msf.mvpsample.MainActivityContract.*;

public class MainActivityPresenter implements Presenter {

    private MainActivityContract.View mView;
    private Model model;


    public MainActivityPresenter(MainActivityContract.View view)
    {
        mView =  view;
        initPresenter();

    }

    private void initPresenter() {

         model = new MainActivityModel();
         mView.initView();
    }


    @Override
    public void onClick(View view) {


                mView.setViewData(model.getData());

    }
}

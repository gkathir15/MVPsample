package com.msf.mvpsample.view;

public interface MainActivityContract {



    interface  View{
        void initView();
        void setViewData(String displayData);


    }

    interface Model
    {
        String getData();
        void requestPermission();
        String getUpdatedLocation();
    }

    interface Presenter{

        void onClick(android.view.View view);


    }

}

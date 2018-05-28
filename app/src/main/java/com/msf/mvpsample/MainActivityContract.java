package com.msf.mvpsample;

public interface MainActivityContract {



    interface  View{
        void initView();
        void setViewData(String displayData);

    }

    interface Model
    {
        String getData();

    }

    interface Presenter{

        void onClick(android.view.View view);
    }
}

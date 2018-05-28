package com.msf.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.msf.mvpsample.MainActivityContract.*;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{


    private Presenter presenter;
    TextView textView;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);

    }

    @Override
    public void initView() {

        textView = findViewById(R.id.dummy);
        startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClick(v);
            }
        } );

    }

    @Override
    public void setViewData(String displayData) {

        textView.setText(displayData);

    }
}

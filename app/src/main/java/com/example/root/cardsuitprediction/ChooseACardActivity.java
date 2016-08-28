package com.example.root.cardsuitprediction;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.example.root.cardsuitprediction.R;

public class ChooseACardActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private int currentImageID;
    ImageView suitImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_acard);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        suitImageView = (ImageView)findViewById(R.id.clubsImageView);
        suitImageView.setVisibility(View.INVISIBLE);


        Button clubsButton = (Button)findViewById(R.id.clubsbutton);

        clubsButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick (View v) {
                        suitImageView.setVisibility(View.INVISIBLE);
                        suitImageView = (ImageView)findViewById(R.id.clubsImageView);
                    }
                }
        );

        Button heartsButton = (Button)findViewById(R.id.heartsbutton);

        heartsButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick (View v) {
                        suitImageView.setVisibility(View.INVISIBLE);
                        suitImageView = (ImageView)findViewById(R.id.heartsImageView);
                    }
                }
        );

        Button spadesButton = (Button)findViewById(R.id.spadesbutton);

        spadesButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick (View v) {
                        suitImageView.setVisibility(View.INVISIBLE);
                        suitImageView = (ImageView)findViewById(R.id.spadesImageView);
                    }
                }
        );

        Button diamondsButton = (Button)findViewById(R.id.diamondsbutton);

        diamondsButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick (View v) {
                        suitImageView.setVisibility(View.INVISIBLE);
                        suitImageView = (ImageView)findViewById(R.id.diamondsImageView);
                    }
                }
        );

        Button resetButton = (Button)findViewById(R.id.resetbutton);

        resetButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick (View v) {
                        suitImageView.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] > 0.5) {
            suitImageView.setVisibility(View.VISIBLE);

        }
    }

}
package com.jorgesys.advanced.sensorlight;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    SensorManager mySensorManager;
    Sensor mySensor;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfo = (TextView)findViewById(R.id.txtInfo);
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(mySensor != null){
            Log.d(TAG, " existe : " + mySensor.getName());
            mySensorManager.registerListener(
                    this,
                    mySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            Log.d(TAG, "Sensor.TYPE_LIGHT NOT Available");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        txtInfo.setText("Light level : "  + String.valueOf(sensorEvent.values[0]) + " lx");
        Log.i(TAG, "Light level : "  + String.valueOf(sensorEvent.values[0]) + " lx");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

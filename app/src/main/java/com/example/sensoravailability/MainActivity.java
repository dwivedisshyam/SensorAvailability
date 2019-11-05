package com.example.sensoravailability;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int sensorArray[] = {Sensor.TYPE_GYROSCOPE, Sensor.TYPE_HEART_RATE, Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_MOTION_DETECT,Sensor.TYPE_PROXIMITY, Sensor.TYPE_STEP_COUNTER,
            Sensor.TYPE_AMBIENT_TEMPERATURE, Sensor.TYPE_LIGHT};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sensor = (Spinner)findViewById(R.id.sensor);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.sensorList));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sensor.setAdapter(adapter);
        sensor.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(sensorArray[i])!=null){
            Toast.makeText(this,"Sensor Available", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Sensor Not Available", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

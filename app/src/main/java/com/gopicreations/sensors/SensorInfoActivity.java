package com.gopicreations.sensors;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SensorInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();

        setContentView(com.gopicreations.sensors.R.layout.activity_sensor_info);
        TextView sensorName =(TextView)findViewById(com.gopicreations.sensors.R.id.sensorInfo);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(getIntent().getIntExtra("sensorInfo", -1));

        String sensorDetails = "";
        sensorDetails += "\n" + sensor.getName();
        sensorDetails += res.getString(R.string.sensorinfo_vendor) + sensor.getVendor();
        sensorDetails += res.getString(R.string.sensorinfo_version) + sensor.getVersion();
        sensorDetails += res.getString(R.string.sensorinfo_power) + sensor.getPower() + res.getString(R.string.sensorinfo_power_unit);
        sensorDetails += res.getString(R.string.sensorinfo_resolution) + sensor.getResolution();
        sensorDetails += "\n";
        sensorName.setText(sensorDetails);
    }

}

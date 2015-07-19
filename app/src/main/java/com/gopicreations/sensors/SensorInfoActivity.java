package com.gopicreations.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SensorInfoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.gopicreations.sensors.R.layout.activity_sensor_info);
        TextView sensorName =(TextView)findViewById(com.gopicreations.sensors.R.id.sensorInfo);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(getIntent().getIntExtra("sensorInfo", -1));

        String sensorDetails = "";
        sensorDetails += "\n" + sensor.getName();
        sensorDetails += "\n Vendor : " + sensor.getVendor();
        sensorDetails += "\n Version : " + sensor.getVersion();
        sensorDetails += "\n Power : " + sensor.getPower() + "mA";
        sensorDetails += "\n Resolution : " + sensor.getResolution();
        sensorDetails += "\n";
        sensorName.setText(sensorDetails);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.gopicreations.sensors.R.menu.menu_sensor_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.gopicreations.sensors.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

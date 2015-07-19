package com.gopicreations.sensors;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends ListActivity {

    private List<Sensor> sensors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.gopicreations.sensors.R.layout.activity_main);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //ArrayAdapter<Sensor> sensorAdapter = new ArrayAdapter(this,
        //        android.R.layout.simple_list_item_1, sensors.toArray());
        //setListAdapter(sensorAdapter);
        setListAdapter(new SensorAdapter(this, 0, sensors));
        //getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, SensorInfoActivity.class);
        intent.putExtra("sensorInfo", sensors != null ? sensors.get(position).getType() : -1);
        startActivity(intent);
    }
}

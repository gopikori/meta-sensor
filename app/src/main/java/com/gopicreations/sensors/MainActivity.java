package com.gopicreations.sensors;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView sensorSummaryTextView;
    ListView listView;
    private List<Sensor> sensors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();

        setContentView(com.gopicreations.sensors.R.layout.activity_main);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        sensorSummaryTextView = (TextView) findViewById(R.id.sensorSummary);
        sensorSummaryTextView.setText(Html.fromHtml(String.format(res.getString(R.string.sensorlist_summary_count), sensors.size())));

        listView = (ListView) findViewById(R.id.sensorList);
        listView.setAdapter(new SensorAdapter(this, 0, sensors));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), SensorInfoActivity.class);
                intent.putExtra("sensorInfo", sensors != null ? sensors.get(position).getType() : -1);
                startActivity(intent);
            }
        });
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

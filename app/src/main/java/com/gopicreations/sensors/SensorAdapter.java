package com.gopicreations.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SensorAdapter extends ArrayAdapter<Sensor>{
    private int resource;
    public SensorAdapter(Context context, int resource, List<Sensor> sensors) {
        super(context, resource, sensors);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        //Get the current alert object
        Sensor sensor = getItem(position);

        //Inflate the view
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(com.gopicreations.sensors.R.layout.list_items, parent, false);
        }
        //Get the text boxes from the listitem.xml file
        TextView sensorName =(TextView)convertView.findViewById(com.gopicreations.sensors.R.id.sensorName);
        TextView sensorMfg =(TextView)convertView.findViewById(com.gopicreations.sensors.R.id.sensorMfg);

        //Assign the appropriate data from our alert object above
        sensorName.setText(Html.fromHtml("<h2>" + sensor.getName() + "</h2>" +
                "</br><i>" + sensor.getVendor() + "</i>"));

        return convertView;
    }
}

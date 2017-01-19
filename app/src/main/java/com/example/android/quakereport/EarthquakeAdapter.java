package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;


        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);

        Earthquake currentEarthquake = getItem(position);

        TextView tvMagnitude = (TextView) listItemView.findViewById(R.id.tvMagnitude);
        TextView tvLocationOffset = (TextView) listItemView.findViewById(R.id.tvLocationOffset);
        TextView tvLocation = (TextView) listItemView.findViewById(R.id.tvLocation);
        TextView tvDate = (TextView) listItemView.findViewById(R.id.tvDate);
        TextView tvTime = (TextView) listItemView.findViewById(R.id.tvTime);

        GradientDrawable magnitudeCircle = (GradientDrawable) tvMagnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        tvMagnitude.setText(formatMagnitude(currentEarthquake.getmMagnitude()));
        magnitudeCircle.setColor(magnitudeColor);
        String location = currentEarthquake.getmLocation();
        String locationOffset = "Near the";
        if (location.contains("km") && location.contains("of")) {
            String[] parts = location.split("of");
            locationOffset = parts[0] + " of";
            location = parts[1];
        }

        tvLocationOffset.setText(locationOffset);
        tvLocation.setText(location);

        //creating a date object from unix time in long and formating it in desired way
        //in methods dormat date and time
        Date dateOfEarthquake = new Date(currentEarthquake.getmTimeInMilis());

        tvDate.setText(formatDate(dateOfEarthquake));
        tvTime.setText(formatTime(dateOfEarthquake));
        return listItemView;

    }


    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");
        return dateFormat.format(date);
    }

    private String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(date);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

}

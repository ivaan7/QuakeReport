package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


/**
 * Created by Ivan on 15.1.2017..
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
       // Log.i(LOG_TAG," onStartLoading() ");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
      //  Log.i(LOG_TAG," loadInBackground() ");
        if (mUrl == null) {
            return null;
        }
        List<Earthquake> quakes = QueryUtils.fetchEarthquakeData(mUrl);
        return quakes;
    }

}

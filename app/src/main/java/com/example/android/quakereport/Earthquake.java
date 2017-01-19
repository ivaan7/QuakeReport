package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilis;
    private String mUrl;

    public Earthquake(double mMagnitude, String mLocation, long mTimeInMilis, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilis = mTimeInMilis;
        this.mUrl = mUrl;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmTimeInMilis() {
        return mTimeInMilis;
    }

    public String getmUrl() {
        return mUrl;
    }
}

package com.example.mikeacre.lincolnparktour;

/**
 * Created by mikeacre on 11/12/2016.
 */

public class Location {
    private String mTitle;
    private String mDescription;
    private String mGeoLocation;
    private int mResImage;

    public Location(String title, String description, String geoLocation, int resImage){
        mTitle = title;
        mDescription = description;
        mGeoLocation = geoLocation;
        mResImage = resImage;
    }

    public Location(String title, String description, String geoLocation){
        mTitle = title;
        mDescription = description;
        mGeoLocation = geoLocation;
        mResImage = -1;
    }

    public String getTitle(){return mTitle;}

    public String getDescription(){return mDescription;}

    public String getGeoLocation() {return mGeoLocation;}

    public int getResImage(){return mResImage;}

    public boolean hasImage() {
        return mResImage != -1;
    }

}

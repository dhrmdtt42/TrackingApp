package com.ajir.dharam;

/**
 * Created by Dharam on 7/28/2018.
 */

public class UserLocation {

     int id;
    double lattitude;
     double longitude;
     String  locationName;

    public UserLocation(){}
    public UserLocation(int id,double lattitude, double longitude, String locationName) {
        this.id = id;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

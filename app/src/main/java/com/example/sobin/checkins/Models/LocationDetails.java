package com.example.sobin.checkins.Models;

import java.io.Serializable;

public class LocationDetails implements Serializable{
    public void setTime(double time) {
        this.time = time;
    }

    double lat,lng,time;
    String name,address,description,photopath;

    public double getTime() {

        return time;
    }

    public String getPhotopath() {

        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

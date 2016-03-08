package com.example.clarissapink.leafapp.models;

public class HDBFlat {

    private int iD;
    private String roomType;
    private String priceRange;
    private String location;
    private Boolean availabilityStatus;

    public HDBFlat(int iD, String roomType, String priceRange, String location, Boolean availabilityStatus) {
        this.iD = iD;
        this.roomType = roomType;
        this.priceRange = priceRange;
        this.location = location;
        this.availabilityStatus = availabilityStatus;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}

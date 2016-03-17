package com.example.clarissapink.leafapp.models;

public class HDBFlat {

    private int id;
    private int year;
    private String town;
    private String roomType;
    private String minPrice;
    private String maxPrice;
    private String minPriceLess;
    private String maxPriceLess;

    public HDBFlat(){
    }

    public HDBFlat(int id, int year, String town, String roomType, String minPrice, String maxPrice, String minPriceLess, String maxPriceLess) {
        this.id = id;
        this.year = year;
        this.town = town;
        this.roomType = roomType;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minPriceLess = minPriceLess;
        this.maxPriceLess = maxPriceLess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPriceLess() {
        return minPriceLess;
    }

    public void setMinPriceLess(String minPriceLess) {
        this.minPriceLess = minPriceLess;
    }

    public String getMaxPriceLess() {
        return maxPriceLess;
    }

    public void setMaxPriceLess(String maxPriceLess) {
        this.maxPriceLess = maxPriceLess;
    }
}
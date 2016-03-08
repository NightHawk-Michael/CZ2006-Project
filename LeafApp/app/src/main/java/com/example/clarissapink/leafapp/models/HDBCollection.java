package com.example.clarissapink.leafapp.models;

import java.util.ArrayList;

public class HDBCollection {

    private ArrayList<HDBFlat> collection;
    private String region;

    public HDBCollection(ArrayList<HDBFlat> collection, String region) {
        this.collection = collection;
        this.region = region;
    }

    public ArrayList<HDBFlat> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<HDBFlat> collection) {
        this.collection = collection;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

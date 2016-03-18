package com.example.clarissapink.leafapp.models;

import java.util.ArrayList;
import java.util.List;

public class HDBCollection {

    private List<HDBFlat> collection;
//    private String region;

    public HDBCollection() {
    }

    public HDBCollection(List<HDBFlat> collection) {
        this.collection = collection;
//        this.region = region;
    }

    public List<HDBFlat> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<HDBFlat> collection) {
        this.collection = collection;
    }
}
//
//    public String getRegion() {
//        return region;
//    }
//
//    public void setRegion(String region) {
//        this.region = region;
//    }
//}

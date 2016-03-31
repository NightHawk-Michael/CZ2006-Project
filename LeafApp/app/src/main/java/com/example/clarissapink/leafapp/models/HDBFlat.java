package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HDBFlat implements Parcelable {

    private int id;
    private int year;
    private String town;
    private String roomType;
    private double minPrice;
    private double maxPrice;
    private String minPriceLess;
    private String maxPriceLess;
    private String address;
    public HDBFlat(){
    }

    public HDBFlat(int id, int year, String town, String roomType, String minPrice, String maxPrice, String minPriceLess, String maxPriceLess) {
        this.id = id;
        this.year = year;
        this.town = town;
        this.roomType = roomType;
        this.minPrice = Double.parseDouble(minPrice);
        this.maxPrice = Double.parseDouble(maxPrice);
        this.minPriceLess = minPriceLess;
        this.maxPriceLess = maxPriceLess;
        this.setUpHDBaddress();

    }

    /**
     * Contructor for when using parcelable to pass object between activities
     * @param in
     */
    public HDBFlat(Parcel in){
        this.id = in.readInt();
        this.year = in.readInt();
        this.town = in.readString();
        this.roomType = in.readString();
        this.minPrice = in.readDouble();
        this.maxPrice = in.readDouble();
        this.minPriceLess = in.readString();
        this.maxPriceLess = in.readString();
        this.address = in.readString();
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

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = Double.parseDouble(minPrice);
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = Double.parseDouble(maxPrice);
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

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress (){
        return this.address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(year);
        dest.writeString(town);
        dest.writeString(roomType);
        dest.writeDouble(minPrice);
        dest.writeDouble(maxPrice);
        dest.writeString(minPriceLess);
        dest.writeString(maxPriceLess);
        dest.writeString(address);
    }

    private void setUpHDBaddress(){
        List<String> punggol;
        List<String> sengKang;
        List<String> jurongWest;
        List<String> bukitPanjang;
        List<String> woodlands;
        List<String> choaChuKang;
        List<String> yishun;
        List<String> sembawang;

        punggol = Arrays.asList("315 Punggol Dr","266 Punggol Way","174D Edgedale Plains ",
                "271 Punggol Walk","101B Punggol Field","622 Punggol Central");
        sengKang = Arrays.asList("224B Compassvale Walk","215 Jalan Kayu","317A Anchorvale Rd",
                "194 Rivervale Dr","143 Rivervale Dr","50 Sengkang Square");
        sembawang = Arrays.asList("30 Sembawang Dr","604 Sembawang Rd");
        jurongWest = Arrays.asList("714 Jurong West Street 71","813 Jurong West Street 81",
                "1 Jurong West Ave 2");
        choaChuKang = Arrays.asList("309 Choa Chu Kang Avenue 4","329 Choa Chu Kang Avenue 3",
                "2A Hong San Walk","253 Choa Chu Kang Avenue 1");
        bukitPanjang = Arrays.asList("105 Cashew Rd","Blk 487 Segar Rd",
                "50 Cashew Rd","31 Bangkit Rd");
        yishun = Arrays.asList("156 Yishun Street 11","219 Yishun Street 21","748 Yishun Street 72");
        woodlands = Arrays.asList("30 Woodlands Avenue 2","1 Rosewood Dr",
                "71 Woodgrove Ave","3 Woodgrove Dr","15 Marsiling Ln");


        if(town.equals("Punggol")){
            switch (year){
                case 2008: this.address = punggol.get(0);
                    break;
                case 2009: this.address = punggol.get(1);
                    break;
                case 2010: this.address = punggol.get(2);
                    break;
                case 2011: this.address = punggol.get(3);
                    break;
                case 2012: this.address = punggol.get(4);
                    break;
                case 2013: this.address = punggol.get(5);
                    break;
                default: break;
            }
        } else if(town.equals("Sengkang")){
            switch (year){
                case 2008: this.address = sengKang.get(0);
                    break;
                case 2009: this.address = sengKang.get(1);
                    break;
                case 2010: this.address = sengKang.get(2);
                    break;
                case 2011: this.address = sengKang.get(3);
                    break;
                case 2012: this.address = sengKang.get(4);
                    break;
                case 2013: this.address = sengKang.get(5);
                    break;
                default: break;
            }
        } else if(town.equals("Sembawang")) {
            switch (year) {
                case 2011:
                    this.address = sembawang.get(0);
                    break;
                case 2013:
                    this.address = sembawang.get(1);
                    break;
                default:
                    break;
            }
        }else if(town.equals("Jurong West")){
            switch (year) {
                case 2008:
                    this.address = jurongWest.get(0);
                    break;
                case 2009:
                    this.address = jurongWest.get(1);
                    break;
                case 2010:
                    this.address = jurongWest.get(2);
                default:
                    break;
            }
        }else if(town.equals("Bukit Panjang")){
            switch (year){
                case 2008: this.address = bukitPanjang.get(0);
                    break;
                case 2009: this.address = bukitPanjang.get(1);
                    break;
                case 2010: this.address = bukitPanjang.get(2);
                    break;
                case 2011: this.address = bukitPanjang.get(3);
                    break;
                default: break;
            }
        }else if(town.equals("Yishun")){
            switch (year){
                case 2011: this.address = yishun.get(0);
                    break;
                case 2012: this.address = yishun.get(1);
                    break;
                case 2013: this.address = yishun.get(2);
                    break;
                default: break;
            }
        }else if(town.equals("Woodlands")){
            switch (year){
                case 2008: this.address = woodlands.get(0);
                    break;
                case 2009: this.address = woodlands.get(1);
                    break;
                case 2010: this.address = woodlands.get(2);
                    break;
                case 2012: this.address = woodlands.get(3);
                    break;
                case 2013: this.address = woodlands.get(4);
                    break;
                default: break;
            }
        }else if(town.equals("Choa Chu Kang")){
            switch (year){
                case 2009: this.address = choaChuKang.get(0);
                    break;
                case 2011: this.address = choaChuKang.get(1);
                    break;
                case 2012: this.address = choaChuKang.get(2);
                    break;
                case 2013: this.address = choaChuKang.get(3);
                    break;
                default: break;
            }
        }

    }


    public static Parcelable.Creator<HDBFlat> CREATOR = new Parcelable.Creator<HDBFlat>(){

        @Override
        public HDBFlat createFromParcel (Parcel source){
            return new HDBFlat(source);
        }
        public HDBFlat[] newArray(int size) {
            return new HDBFlat[size];
        }
    };


}
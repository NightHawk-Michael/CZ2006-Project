package com.example.clarissapink.leafapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GrantInformation implements Parcelable{

    private String roomType;
    private String typeOfApplication;
    private String grantAmt;

    public GrantInformation(String roomType, String typeOfApplication, String grantAmt) {
        this.roomType = roomType;
        this.typeOfApplication = typeOfApplication;
        this.grantAmt = grantAmt;
    }
    public GrantInformation(Parcel in){
        this.roomType = in.readString();
        this.typeOfApplication = in.readString();
        this.grantAmt = in.readString();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getTypeOfApplication() {
        return typeOfApplication;
    }

    public void setTypeOfApplication(String typeOfApplication) {
        this.typeOfApplication = typeOfApplication;
    }

    public String getGrantAmt() {
        return grantAmt;
    }

    public void setGrantAmt(String grantAmt) {
        this.grantAmt = grantAmt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(roomType);
        dest.writeString(typeOfApplication);
        dest.writeString(grantAmt);
    }
    public static Parcelable.Creator<GrantInformation> CREATOR = new Parcelable.Creator<GrantInformation>(){

        @Override
        public GrantInformation createFromParcel (Parcel source){
            return new GrantInformation(source);
        }
        public GrantInformation[] newArray(int size) {
            return new GrantInformation[size];
        }
    };

}

package com.example.clarissapink.leafapp.models;

public class GrantInformation {

    private String roomType;
    private String typeOfApplication;
    private String grantAmt;

    public GrantInformation(String roomType, String typeOfApplication, String grantAmt) {
        this.roomType = roomType;
        this.typeOfApplication = typeOfApplication;
        this.grantAmt = grantAmt;
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
}

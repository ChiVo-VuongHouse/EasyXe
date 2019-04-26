package com.example.easyxe.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String mUserName;
    private String mUserCity;
    private String mUserPhone;
    private String mUserLocation;
    private int mImage;

    public User(String mUserName, String mUserCity, String mUserPhone, String mUserLocation, int mImage) {
        this.mUserName = mUserName;
        this.mUserCity = mUserCity;
        this.mUserPhone = mUserPhone;
        this.mUserLocation = mUserLocation;
        this.mImage = mImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserCity() {
        return mUserCity;
    }

    public void setmUserCity(String mUserCity) {
        this.mUserCity = mUserCity;
    }

    public String getmUserPhone() {
        return mUserPhone;
    }

    public void setmUserPhone(String mUserPhone) {
        this.mUserPhone = mUserPhone;
    }

    public String getmUserLocation() {
        return mUserLocation;
    }

    public void setmUserLocation(String mUserLocation) {
        this.mUserLocation = mUserLocation;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mUserName);
        out.writeString(mUserCity);
        out.writeString(mUserLocation);
        out.writeString(mUserPhone);
        out.writeInt(mImage);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        this.mUserName = in.readString();
        this.mUserCity = in.readString();
        this.mUserLocation = in.readString();
        this.mUserPhone = in.readString();
        this.mImage = in.readInt();

    }
}

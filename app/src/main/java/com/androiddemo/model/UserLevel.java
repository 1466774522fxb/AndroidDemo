package com.androiddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserLevel implements Parcelable {
    private int mId;
    private String mName;//等级名称
    private int mScore;//等级积分下限

    public UserLevel() {

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        this.mScore = score;
    }
    
    public static Creator<UserLevel> getCreator() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeInt(mScore);
    }

    public UserLevel(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mScore = in.readInt();
    }

    public static final Creator<UserLevel> CREATOR = new Creator<UserLevel>() {
        public UserLevel createFromParcel(Parcel in) {
            return new UserLevel(in);
        }

        public UserLevel[] newArray(int size) {
            return new UserLevel[size];
        }
    };
}

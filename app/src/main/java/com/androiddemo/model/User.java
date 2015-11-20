package com.androiddemo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.Gson;

public class User implements Parcelable {

    private int mId;
    private String mMobile;//手机号（登录账号）
    private String mNickname;//昵称
    private String mAvatar;//头像
    private String mSex;//性别（男，女）
    private UserLevel mLevel;//等级
    private int mTotalScore;//总积分
    private int mScore;//当前积分
    private long mCreateTime;//创建时间
    private String mTel;//固话
    private String mIdCard;//身份证号
    private long mBirthday;//出生年月
    private int mCreator;//创建者（0：自己注册，非0：创建者ID）
    private long mUpdateTime;//更新时间
    private int mUpdator;//更新者ID（0：用户自己更新，非0：后台编辑人员ID）
    private int mIsDelete;//是否删除（0：未删除，1：已删除）

    public User() {

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        this.mMobile = mobile;
    }

    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        this.mAvatar = avatar;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        this.mSex = sex;
    }

    public UserLevel getLevel() {
        return mLevel;
    }

    public void setLevel(UserLevel userLevel) {
        this.mLevel = userLevel;
    }

    public int getTotalScore() {
        return mTotalScore;
    }

    public void setTotalScore(int totalScore) {
        this.mTotalScore = totalScore;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        this.mScore = score;
    }

    public long getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(long createTime) {
        this.mCreateTime = createTime;
    }

    public String getTel() {
        return mTel;
    }

    public void setTel(String tel) {
        this.mTel = tel;
    }

    public String getIdCard() {
        return mIdCard;
    }

    public void setIdCard(String idCard) {
        this.mIdCard = idCard;
    }

    public long getBirthday() {
        return mBirthday;
    }

    public void setBirthday(long birthday) {
        this.mBirthday = birthday;
    }

    public int getCreatorId() {
        return mCreator;
    }

    public void setCreatorId(int creator) {
        this.mCreator = creator;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.mUpdateTime = updateTime;
    }

    public int getUpdator() {
        return mUpdator;
    }

    public void setUpdator(int updator) {
        this.mUpdator = updator;
    }

    public boolean isDelete() {
        return mIsDelete == 1 ? true : false;
    }

    public void setIsDelete(int isDelete) {
        this.mIsDelete = isDelete;
    }

    public static Creator<User> getCreator() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mMobile);
        dest.writeString(mNickname);
        dest.writeString(mAvatar);
        dest.writeString(mSex);
        dest.writeParcelable(mLevel, 0);
        dest.writeInt(mTotalScore);
        dest.writeInt(mScore);
        dest.writeLong(mCreateTime);
        dest.writeString(mTel);
        dest.writeString(mIdCard);
        dest.writeLong(mBirthday);
        dest.writeInt(mCreator);
        dest.writeLong(mUpdateTime);
        dest.writeInt(mUpdator);
        dest.writeInt(mIsDelete);
    }

    public User(Parcel in) {
        mId = in.readInt();
        mMobile = in.readString();
        mNickname = in.readString();
        mAvatar = in.readString();
        mSex = in.readString();
        mLevel = in.readParcelable(UserLevel.class.getClassLoader());
        mTotalScore = in.readInt();
        mScore = in.readInt();
        mCreateTime = in.readLong();
        mTel = in.readString();
        mIdCard = in.readString();
        mBirthday = in.readLong();
        mCreator = in.readInt();
        mUpdateTime = in.readLong();
        mUpdator = in.readInt();
        mIsDelete = in.readInt();

    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /**
     * 从json串中解析user对象
     *
     * @param json
     * @return
     */
    public static User fromJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        return user;
    }

    /**
     * 把user对象转化成json串
     *
     * @param user
     * @return
     */
    public static String toJson(User user) {
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        return userJson;
    }
}

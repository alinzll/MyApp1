package com.exp.zll.myapp1;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by zll on 2017/11/10.
 * User传值对象
 */

//public class User implements Serializable{
public class User implements Parcelable{
    private String name;
    private int age;

    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in.readString(),in.readInt());
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User(String name,int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeInt(getAge());
    }
}

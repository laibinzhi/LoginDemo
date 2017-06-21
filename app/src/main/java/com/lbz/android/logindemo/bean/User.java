package com.lbz.android.logindemo.bean;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by laibinzhi on 2017/6/21.
 */
public class User implements Serializable {
    @SerializedName("username")
    @NonNull
    private String username;

    @SerializedName("bio")
    @Nullable
    private String bio;

    @SerializedName("name")
    @Nullable
    private String name;

    @SerializedName("country")
    @Nullable
    private String country;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("level_of_education")
    @Nullable
    private String levelOfEducation;

    @SerializedName("goals")
    @Nullable
    private String goals;

    @SerializedName("gender")
    @Nullable
    private String gender;

    @SerializedName("email")
    @Nullable
    private String email;

    @SerializedName("nickname")
    @Nullable
    private String nickName;

    @SerializedName("mobile")
    @Nullable
    private String mobile;

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @Nullable
    public String getBio() {
        return bio;
    }

    public void setBio(@Nullable String bio) {
        this.bio = bio;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(@Nullable String country) {
        this.country = country;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Nullable
    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(@Nullable String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    @Nullable
    public String getGoals() {
        return goals;
    }

    public void setGoals(@Nullable String goals) {
        this.goals = goals;
    }

    @Nullable
    public String getGender() {
        return gender;
    }

    public void setGender(@Nullable String gender) {
        this.gender = gender;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getNickName() {
        return nickName;
    }

    public void setNickName(@Nullable String nickName) {
        this.nickName = nickName;
    }

    @Nullable
    public String getMobile() {
        return mobile;
    }

    public void setMobile(@Nullable String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", isActive=" + isActive +
                ", levelOfEducation='" + levelOfEducation + '\'' +
                ", goals='" + goals + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

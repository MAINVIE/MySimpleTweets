package com.codepath.apps.mysimpletweets.models;

import org.json.JSONException;
import org.json.JSONObject;


public class User {
    private String name;
    private long Uid;
    private String screenName;
    private String profileImageUrl;


    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public long getUid() {
        return Uid;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public static User fromJson(JSONObject json){
        User u=new User();
        try {
            u.name=json.getString("name");
            u.Uid=json.getLong("id");
            u.screenName=json.getString("screen_name");
            u.profileImageUrl=json.getString("profile_image_url");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return u;

    }
}

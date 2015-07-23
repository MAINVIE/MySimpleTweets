package com.codepath.apps.mysimpletweets.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Tweet {


    //private String Body;
    private long uid;
    private User user;
    private String createdAt;
    private String body;

    public User getUser() {
        return user;
    }

    public String getBody() {

        return body;
    }

    public long getUid() {

        return uid;
    }

    public String getCreatedAt() {

        return createdAt;
    }



    public static Tweet fromJson(JSONObject jsonObject) {
        Tweet tweet= new Tweet();
        try {
            tweet.body =jsonObject.getString("text");
            tweet.uid =jsonObject.getLong("id");
            tweet.createdAt=jsonObject.getString("created at");
            tweet.user=User.fromJson(jsonObject.getJSONObject("user"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return tweet;
    }
    public static ArrayList<Tweet> fromJsonArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets=new ArrayList<>();
        for (int i=0 ; i< jsonArray.length();i++){
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet=Tweet.fromJson(tweetJson);
                if (tweet != null){
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }
        return tweets;
    }
}

package com.codepath.apps.mysimpletweets.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.R;

import com.squareup.picasso.Picasso;

import java.util.List;




public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context,0, tweets);
    }

    //override and custom template
    //view older pattern
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Tweet tweet=getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet,parent,false);
        }
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUserName= (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody= (TextView) convertView.findViewById(R.id.tvBody);

        tvBody.setText(tweet.getBody());
        tvUserName.setText(tweet.getUser().getScreenName());
        ivProfileImage.setImageResource(android.R.color.transparent);
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);

        return convertView;
    }
}

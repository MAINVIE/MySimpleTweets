package com.codepath.apps.mysimpletweets;

import org.scribe.builder.api.Api;

import org.scribe.builder.api.TwitterApi;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


public class TwitterClient extends OAuthBaseClient {

	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "IlP1w4Dhey9JHs5B7fIgxBoIB";       // Change this
	public static final String REST_CONSUMER_SECRET = "A9VZsqZ1r32BPnAhoNJ6qcbUuPgbLps7s8iDnMZcvTA9ghxWsS"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://MyMACTweets"; // Change this (here and in manifest)




		public TwitterClient(Context context) {
			super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
		}


	// home timeline

	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
	public void getHomeTimeline(AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		RequestParams params = new RequestParams();
		params.put("count",25);
		params.put("since_id",1);
		getClient().get(apiUrl,params,handler);
	}
}
	/*endpoints:
	getting home timeline
	Get statuses/home_timeline.json
	count=50
	since_id=1
		*/
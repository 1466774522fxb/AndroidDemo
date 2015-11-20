package com.androiddemo.http;


import com.androiddemo.utils.Log;
import com.loopj.android.http.AsyncHttpClient;

public class RestClient {

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		if (params == null) {
			params = new RequestParams();
		}
		Log.i("http request url", url + "?" + params.toString());
		client.get(url, params, responseHandler);
	}

	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		if (params == null) {
			params = new RequestParams();
		}
		Log.i("http request url", url + "?" + params.toString());
		client.post(url, params, responseHandler);
	}
}

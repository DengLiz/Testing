package com.facebook.ads.utils;

import java.io.IOException;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class SSLConnection {
	private final OkHttpClient client = buildClient();
	public String request(String url,Map<String,String> map) {
		 Builder requestBuilder = new Request.Builder();
		 HttpUrl.Builder urlBuilder =HttpUrl.parse(url).newBuilder();
		 addQueryParam(map,urlBuilder);
		 System.out.println(urlBuilder.toString());
		 requestBuilder.url(urlBuilder.build());
		 Request request = requestBuilder.build();
		 String responseBody = null;
		 Response response;
			try {
				response = client.newCall(request).execute();
				 if (response.isSuccessful()) {
					responseBody = response.body().string();
			    } else {
			        throw new IOException("Unexpected code " + response);
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responseBody;
	}
	private OkHttpClient buildClient() {
		OkHttpClient client = new OkHttpClient.Builder()
				.build();
		return client;
	}
	private void addQueryParam(Map<String,String> map,HttpUrl.Builder urlbuilder) {
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			urlbuilder.addQueryParameter(key, map.get(key));
		}
	}
}

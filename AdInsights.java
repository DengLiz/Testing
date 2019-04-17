package com.citi.dwh.facebook;

import java.util.HashMap;
import java.util.Map;

import com.facebook.ads.utils.SSLConnection;

public class AdInsights {
	private String access_token = "EAADsK6WJMJABAI6TEyOgyPgMzBT5SaW8fpqITrLn4qUWmkFCwAQUhtu86gYWLFwGiUaD4TxZAQb1BmgBqACB3IC47dhjZAKALb7ipaRh2i9AIK1GbsTfDulACjOcm3zKpXsmwauJYWUeuVBEohlABf43tWz8ZCwG5HySGcsZAan9BFAG2S19NWIICRo4jAYZD";
	private String ad_account_id = "329320507715808";
	private String app_secret = "99bbfb2f90ecd64f1bf3a994a9419244";
	private String app_id = "259672204980368";
	public void getAdsInsights() {
		String url = "https://graph.facebook.com/v3.2/act_"+ad_account_id+"/insights";
		Map<String,String> map = new HashMap<String,String>();
		map.put("access_token", access_token);
		map.put("level", "ad");
		SSLConnection ssl = new SSLConnection();
		String response = ssl.request(url,map);
		System.out.println(response);
	}
	
}

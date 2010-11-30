package com.chompon.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChomponClient {
    
    private String publisherId;
    private String authKey;
    
    public ChomponClient(String publisherId, String authKey) {
        this.publisherId = publisherId;
        this.authKey = authKey;
    }
    
    public GetDealsResponse getDeals(String sid, String did, boolean showIfTipped) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getDeals");
        
        if (sid != null) {
            params.put("sid", did);
        }
        
        if (did != null) {
            params.put("did", did);
        }

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetDealsResponse.class);
    }
    
    public GetDealsResponse getDealsByZip(String zip, boolean returnPastDeals) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getDealsByZip");
        params.put("zip", zip);
        params.put("past", returnPastDeals ? "true" : "false");

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetDealsResponse.class);
    }
    
    private String executeRequest(Map<String, String> params) throws IOException {
        
        params.put("pid", publisherId);
        params.put("auth", authKey);
        params.put("type", "json");
        
        StringBuffer sb = new StringBuffer();
        
        int i = 0;
        for (String key : params.keySet()) {
            
            sb.append(key + "=" + params.get(key));
            
            if (i + 1 < params.size()) {
                sb.append("&");
            }
            
            i++;
        }
        
        URL url;
        try {
            url = new URL("https://www.chompon.com/api.php?" + sb.toString());
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setDefaultUseCaches(false);
        conn.setAllowUserInteraction(false);
        HttpURLConnection.setFollowRedirects(false);
        
        InputStream is = conn.getInputStream();
        
        String response = IOUtils.toString(is);
        
        if (conn.getResponseCode() != 200) {
            throw new IOException("Got error response: " + response);
        } else {
            return response;
        }
    }
}

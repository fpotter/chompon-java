package com.chompon.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.net.URLCodec;
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
    
    /**
     * Get information about deals. Filter by deal-id to look up one deal,
     * publisher-id to look up all deals by a particular publisher, or store-id
     * to look up deals from a store.
     * 
     * @param sid If not null, return deals for this store id
     * @param did If not null, return a specific deal.
     * @param showIfTipped Show whether or not a deal has tipped, and is on.
     * @return
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetDealsResponse getDeals(String sid, String did, boolean showIfTipped) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getDeals");
        
        if (sid != null) {
            params.put("sid", did);
        }
        
        if (did != null) {
            params.put("did", did);
        }
        
        params.put("ctipped", showIfTipped ? "true" : "false");

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetDealsResponse.class);
    }
    
    /**
     * Get info on deals in a specific zip code.
     * 
     * @param zip A five digit zip code.
     * @param returnPastDeals If true, only information about past deals will be
     *            shown. If false, only current deals will show.
     * @return
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetDealsResponse getDealsByZip(String zip, boolean returnPastDeals) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getDealsByZip");
        params.put("zip", zip);
        params.put("past", returnPastDeals ? "true" : "false");

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetDealsResponse.class);
    }

    /**
     * Get information about specifc deal, for a specific user. Returns savings
     * and final cost information for this specific user.
     * 
     * @param uid A user id, or external user id.
     * @param did A specific deal id
     * @param showIfTipped Show whether or not a deal has tipped, and is on.
     * @return
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetDealsResponse getDealForUser(String uid, String did, boolean showIfTipped) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getDealForUser");
        
        if (uid != null) {
            params.put("uid", uid);
        }
        
        if (did != null) {
            params.put("did", did);
        }
        
        params.put("ctipped", showIfTipped ? "true" : "false");

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetDealsResponse.class);
    }
    
    /**
     * Get info about a specific user. Must specify either UID or email
     * 
     * @param uid User's ID
     * @param email User's Email Address
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetUserInfoResponse getUserInfo(String uid, String email) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getUserInfo");
        
        if (uid != null) {
            params.put("uid", uid);
        }
        
        if (email != null) {
            params.put("email", email);
        }
        
        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetUserInfoResponse.class);
    }
    
    /**
     * Returns user info from email address.
     * 
     * @param email Email Address of user
     * @return
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetUserInfoResponse getUserFromEmail(String email) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getUserFromEmail");
        
        params.put("email", email);
        
        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetUserInfoResponse.class);
    }
    
    /**
     * Get info about a coupon
     * 
     * @param uid User ID
     * @param did Deal ID (can be null)
     * @param couponId Coupon ID (can be null)
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetCouponInfoResponse getCouponInfo(String uid, String did, String couponId) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getCouponInfo");
        
        if (uid != null) {
            params.put("uid", uid);
        }
        
        if (did != null) {
            params.put("did", did);
        }

        if (couponId != null) {
            params.put("cid", couponId);
        }

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetCouponInfoResponse.class);
    }
    
    /**
     * Creates a new user. The call is idempotent: if the user already exists,
     * no harm done! This call is most commonly used if you would like to handle
     * your own user-base and you need to sync with our system so we can keep
     * track of certificates.
     * 
     * @param firstName First name
     * @param lastName Last name
     * @param zip Zip code
     * @param email Email Address
     * @param password Password, can be null
     * @param gender Either "male", "female", or null
     * @param birthday Birthday in the form of MM-DD-YYYY
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetUserInfoResponse createUser(String firstName, String lastName, String zip, String email, String password, String gender, String birthday) throws IOException {

        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "createUser");
        
        params.put("fname", firstName);
        params.put("lname", lastName);
        params.put("zip", zip);
        params.put("email", email);
        
        if (password != null) {
            params.put("password", password);
        }
        
        if (gender != null) {
            params.put("gender", gender);
        }
        
        if (birthday != null) {
            params.put("birthd", birthday);
        }
        
        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetUserInfoResponse.class);
    }
    
    public CreateUserEmailZipResponse createUserEmailZip(String zip, String email) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "createUserEmailZip");
        
        params.put("zip", zip);
        params.put("email", email);
        
        if (zip != null) {
            params.put("zip", zip);
        }
        
        if (email != null) {
            params.put("email", email);
        }
        
        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, CreateUserEmailZipResponse.class);
    }
    
    /**
     * Issue coupons to a party for a deal, and returns info about the coupon.
     * 
     * @param userId User ID to issue to
     * @param dealId Deal ID to issue from
     * @param transactionId Optional transaction id if you want to put into our
     *            records a transaction ID for the deal
     * @param referralId Optional referral id as passed to your payment page
     *            through the "rf" GET parameter
     * @param count Number of coupons to issue
     * @return Coupon info
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetCouponInfoResponse issueCoupon(String userId, String dealId, String transactionId, String referralId, int count) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "issueCoupons");

        params.put("uid", userId);
        params.put("did", dealId);
        
        if (transactionId != null) {
            params.put("td", transactionId);
        }

        if (referralId != null) {
            params.put("rf", referralId);
        }

        params.put("count", Integer.toString(count));

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetCouponInfoResponse.class);
    }
    
    /**
     * Get redeeming and checking coupon links
     * 
     * @param storeId Store ID
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetStoreLinksResponse getStoreLinks(String storeId) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("method", "getStoreLinks");

        params.put("sid", storeId);

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetStoreLinksResponse.class);
    }
    
    /**
     * Refund a coupon
     * 
     * @param couponId Coupond ID
     * @return Info about the coupon
     * @throws IOException On any HTTP error or response parse error.
     */
    public GetCouponInfoResponse refundCoupon(String couponId) throws IOException {
        Map<String, String> params = new HashMap<String, String>();

        params.put("method", "refundCoupon");

        params.put("cd", couponId);

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, GetCouponInfoResponse.class);
    }
    

    /**
     * Returns some HTML for displaying a specific deal, or deal in a zip.
     * Either the zip or dealId must be specified.
     * 
     * @param dealId Deal ID
     * @param zip Zip code
     * @return Some HTML
     * @throws IOException On any HTTP error or response parse error.
     */
    public String getDealSEO(String dealId, String zip) throws IOException {
        Map<String, String> params = new HashMap<String, String>();

        params.put("method", "getDealSEO");

        if (dealId != null) {
            params.put("did", dealId);
        }
        
        if (zip != null) {
            params.put("zip", zip);
        }

        String response =  executeRequest(params);
        
        return response;
    }

    /**
     * Generate an RSS Feed of deals for a zip code and/or specific publisher
     * 
     * @param filterByPublisherId If true, only deals for the current publisher
     *            id will be shown.
     * @param zip Zip code
     * @param rssFeedUrl URL of your RSS feed. This is so we can show your RSS
     *            page rather than ChompOn's. Can be null.
     * @param listPageWidgetUrl URL of your list page widget. This is so we can
     *            show your list page rather than ChompOn's. Can be null.
     * @param includeChomponXml If true, extra XML will be added to each RSS
     *            item.
     * @return Rss Feed
     * @throws IOException On any HTTP error or response parse error.
     */
    public String getRSSFeed(boolean filterByPublisherId, String zip, String rssFeedUrl, String listPageWidgetUrl, boolean includeChomponXml) throws IOException {
        
        Map<String, String> params = new HashMap<String, String>();

        params.put("method", "getRSSFeed");

        params.put("usepd", filterByPublisherId ? "true" : "false");
        params.put("zip", zip);
        
        if (rssFeedUrl != null) {
            params.put("rss", URLEncoder.encode(rssFeedUrl, "UTF-8"));
        }
        
        if (listPageWidgetUrl != null) {
            params.put("list", URLEncoder.encode(listPageWidgetUrl, "UTF-8"));
        }
        
        params.put("extra", includeChomponXml ? "true" : "false");
        
        String response =  executeRequest(params);
        
        return response;
    }
    
    /**
     * Adds user credit that can be used for future purchases by this user
     * 
     * @param userId User ID
     * @param creditAmount Credit amount in USD
     * @return
     * @throws IOException On any HTTP error or response parse error
     */
    public AddCreditResponse addCredit(String userId, String creditAmount) throws IOException {
        Map<String, String> params = new HashMap<String, String>();

        params.put("method", "addCredit");

        params.put("uid", userId);
        params.put("amount", creditAmount);

        String response =  executeRequest(params);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(response, AddCreditResponse.class);
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

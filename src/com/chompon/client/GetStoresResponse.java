package com.chompon.client;

import java.util.List;

import com.chompon.client.GetDealsResponse.Deal;
import com.google.gson.annotations.SerializedName;

public class GetStoresResponse extends ChomponResponse {
    
    public static class Store {
        @SerializedName("SID")
        public String storeId;
        
        @SerializedName("Name")
        public String name;
        
        @SerializedName("Twitter")
        public String twitter;
        
        @SerializedName("Facebook")
        public String facebook;
        
        @SerializedName("Website")
        public String website;
        
        @SerializedName("Category")
        public String category;
        
        @SerializedName("TwitterSearch")
        public String twitterSearch;
        
        @SerializedName("Reviews")
        public String reviews;
        
        @SerializedName("PID")
        public String publisherId;
        
        @SerializedName("ImageVersion")
        public String imageVersion;
        
        @SerializedName("SendEmail")
        public String sendEmail;
        
        @SerializedName("Image")
        public String image;
        
        @SerializedName("ImageSmall")
        public String imageSmall;

        @SerializedName("City")
        public String city;
        
        @SerializedName("State")
        public String state;
        
        @SerializedName("Zip")
        public String zip;

        @SerializedName("Street")
        public String street;

        @SerializedName("Phone")
        public String phone;

        @Override
        public String toString() {
            return "Store [category=" + category + ", city=" + city + ", facebook=" + facebook + ", image=" + image + ", imageSmall=" + imageSmall
                    + ", imageVersion=" + imageVersion + ", name=" + name + ", phone=" + phone + ", publisherId=" + publisherId + ", reviews=" + reviews
                    + ", sendEmail=" + sendEmail + ", state=" + state + ", storeId=" + storeId + ", street=" + street + ", twitter=" + twitter
                    + ", twitterSearch=" + twitterSearch + ", website=" + website + ", zip=" + zip + "]";
        }
        
                
        
    }
    
    public List<Store> results;
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("GetStoresResponse [result=" + result + ", results=\n");
        
        for (Store store : results) {
            sb.append("  " + store.toString() + "\n");
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}

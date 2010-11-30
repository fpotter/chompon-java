package com.chompon.client;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetDealsResponse {
    
    public static class Deal {
        @SerializedName("Name")
        public String name;
        
        @SerializedName("RewardEmail")
        public String rewardEmail;

        @SerializedName("PID")
        public String pid;

        @SerializedName("ImageUrl")
        public String imageUrl;

        @SerializedName("CertNote")
        public String certNote;

        @SerializedName("RewardFacebook")
        public String rewardFacebook;

        @SerializedName("TipPoint")
        public String tipPoint;

        @SerializedName("ImageVersion")
        public String imageVersion;

        @SerializedName("Ref3")
        public String ref3;

        @SerializedName("Ref4")
        public String ref4;

        @SerializedName("RewardTwitter")
        public String rewardTwitter;

        @SerializedName("ImageSmall")
        public String imageSmall;

        @SerializedName("Image")
        public String image;

        @SerializedName("IsPoints")
        public String isPoints;

        @SerializedName("Overview")
        public String overview;

        @SerializedName("StartTime")
        public long startTime;

        @SerializedName("DID")
        public String did;
        
        @SerializedName("FinePrint")
        public String finePrint;

        @SerializedName("IsOn")
        public String isOn;

        @SerializedName("Value")
        public String value;

        @SerializedName("RewardShare")
        public String rewardShare;

        @SerializedName("Expiration")
        public String expiration;

        @SerializedName("RewardYelp")
        public String rewardYelp;

        @SerializedName("Ref2")
        public String ref2;

        @SerializedName("ZipsOn")
        public String zipsOn;

        @SerializedName("Ref1")
        public String ref1;

        @SerializedName("UrlTitle")
        public String urlTitle;

        @SerializedName("SID")
        public String sid;

        @SerializedName("Cost")
        public String cost;

        @SerializedName("ShipData")
        public String shipData;

        @SerializedName("EndTime")
        public long endTime;

        @SerializedName("ExtCom")
        public String extDom;

        @SerializedName("Featured")
        public String featured;

        @Override
        public String toString() {
            return "Deal [certNote=" + certNote + ", cost=" + cost + ", did=" + did + ", endTime=" + endTime + ", expiration=" + expiration + ", extDom="
                    + extDom + ", featured=" + featured + ", finePrint=" + finePrint + ", image=" + image + ", imageSmall=" + imageSmall + ", imageUrl="
                    + imageUrl + ", imageVersion=" + imageVersion + ", isOn=" + isOn + ", isPoints=" + isPoints + ", name=" + name + ", overview="
                    + overview + ", pid=" + pid + ", ref1=" + ref1 + ", ref2=" + ref2 + ", ref3=" + ref3 + ", ref4=" + ref4 + ", rewardEmail="
                    + rewardEmail + ", rewardFacebook=" + rewardFacebook + ", rewardShare=" + rewardShare + ", rewardTwitter=" + rewardTwitter
                    + ", rewardYelp=" + rewardYelp + ", shipData=" + shipData + ", sid=" + sid + ", startTime=" + startTime + ", tipPoint=" + tipPoint
                    + ", urlTitle=" + urlTitle + ", value=" + value + ", zipsOn=" + zipsOn + "]";
        }

//      "RewardEmail":"0",
//      "PID":"12",
//      "ImageUrl":null,
//      "CertNote":"",
//      "RewardFacebook":"5",
//      "TipPoint":null,
//      "ImageVersion":"1",
//      "Ref3":null,
//      "Ref4":null,
//      "RewardTwitter":"5",
//      "ImageSmall":"http:\/\/www.chompon.com\/uploads\/stores\/1_s.jpg",
//      "Image":"http:\/\/www.chompon.com\/uploads\/stores\/1.jpg",
//      "IsPoints":"0",
//      "Overview":"Chef Nobu Matsuhisa has created a whole new trend in Japanese cuisine over at Nobu. Don't miss the Black Cod with Miso as you take in the architecture which evokes the beauty of a Japanese countryside. And be adventurous with the sake pairings!",
//      "StartTime":1267095600,
//      "DID":"777",
//      "FinePrint":"Limit 1 per table. Tax and Gratuity not included. Dine-in only. No cash back. Not valid with other offers.",
//      "IsOn":"1",
//      "Value":"45.00",
//      "RewardShare":"5",
//      "Expiration":1299718800,
//      "RewardYelp":"0",
//      "Ref2":null,
//      "ZipsOn":"1",
//      "Ref1":null,
//      "UrlTitle":"nobu-deal",
//      "SID":"1",
//      "Cost":"35.00",
//      "Name":"$35 for Delicious Japanese Cuisine at Nobu ($45 Value)",
//      "ShipData":"1",
//      "EndTime":1291906800,
//      "ExtCom":"0.00",
//      "Featured":"0"
    }
    
    public String result;

    public List<Deal> results;
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("GetDealsResponse [result=" + result + ", results=");
        
        for (Deal deal : results) {
            sb.append("  " + deal.toString() + "\n");
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}
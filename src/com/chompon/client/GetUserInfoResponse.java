package com.chompon.client;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetUserInfoResponse extends ChomponResponse {
    
    public static class UserInfo {
        @SerializedName("UID")
        public String uid;
        
        @SerializedName("Email")
        public String email;
        
        @SerializedName("FName")
        public String firstName;
        
        @SerializedName("LName")
        public String lastName;
        
        @SerializedName("LocID")
        public String locationId;
        
        @SerializedName("AllowEmails")
        public String allowEmails;
        
        @SerializedName("Zip")
        public String zip;
        
        @SerializedName("Created")
        public long created;
        
        @SerializedName("FBID")
        public String facebookId;
        
        @SerializedName("Image")
        public String image;
        
        @SerializedName("AllowReminder")
        public String allowReminder;

        @Override
        public String toString() {
            return "UserInfo [allowEmails=" + allowEmails + ", allowReminder=" + allowReminder + ", created=" + created + ", email=" + email + ", facebookId="
                    + facebookId + ", firstName=" + firstName + ", image=" + image + ", lastName=" + lastName + ", locationId=" + locationId + ", uid=" + uid
                    + ", zip=" + zip + "]";
        }
    }
    
    public List<UserInfo> results;
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("GetUserInfoResponse [result=" + result + ", results=\n");
        
        for (UserInfo result : results) {
            sb.append("  " + result.toString() + "\n");
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}

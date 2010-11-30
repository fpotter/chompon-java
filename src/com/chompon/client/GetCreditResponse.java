package com.chompon.client;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetCreditResponse {
    public static class Credit {
        @SerializedName("UID")
        public String uid;
        
        @SerializedName("Value")
        public String value;

        @Override
        public String toString() {
            return "Credit [uid=" + uid + ", value=" + value + "]";
        }
    }
    
    public String result;
    public List<Credit> results;
    
    @Override
    public String toString() {
        return "AddCreditResponse [result=" + result + ", results=" + results + "]";
    }
}

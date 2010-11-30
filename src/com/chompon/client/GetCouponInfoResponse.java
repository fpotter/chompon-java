package com.chompon.client;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GetCouponInfoResponse extends ChomponResponse {
    
    public static class Coupon {
        @SerializedName("ID")
        public String couponId;
        @SerializedName("UID")
        public String uid;
        @SerializedName("DID")
        public String did;
        @SerializedName("Created")
        public long created;
        @SerializedName("Status")
        public String status;
        @SerializedName("Expires")
        public String expires;
        @SerializedName("Redeemed")
        public String redeemed;
        @SerializedName("Name")
        public String name;
        @SerializedName("FinePrint")
        public String finePrint;
        @SerializedName("TransID")
        public String transId;
        @SerializedName("RevenueID")
        public String revenueId;
        @SerializedName("CostPaid")
        public String costPaid;
        @SerializedName("ExtCode")
        public String extCode;
        @SerializedName("PID")
        public String pid;
        @SerializedName("AID")
        public String aid;
        @SerializedName("AAmount")
        public String aAmount;
        @SerializedName("Shipping")
        public String shipping;
        @SerializedName("StatusText")
        public String statusText;
        
        @Override
        public String toString() {
            return "Coupon [aAmount=" + aAmount + ", aid=" + aid + ", costPaid=" + costPaid + ", couponId=" + couponId + ", created=" + created + ", did="
                    + did + ", expires=" + expires + ", extCode=" + extCode + ", finePrint=" + finePrint + ", name=" + name + ", pid=" + pid + ", redeemed="
                    + redeemed + ", revenueId=" + revenueId + ", shipping=" + shipping + ", status=" + status + ", statusText=" + statusText + ", transId="
                    + transId + ", uid=" + uid + "]";
        }
    }
    
    public List<Coupon> results;
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("GetCouponInfoResponse [result=" + result + ", results=\n");
        
        for (Coupon result : results) {
            sb.append("  " + result.toString() + "\n");
        }
        
        sb.append("]");
        
        return sb.toString();
    }
}

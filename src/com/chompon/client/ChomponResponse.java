package com.chompon.client;


public class ChomponResponse {
    protected String result;
    
    public boolean wasSuccessful() {
        return result.equals("good");
    }
}

package com.chompon.client;

import java.util.List;

public class CreateUserEmailZipResponse {
    
    public static class Result {
        public String result;

        @Override
        public String toString() {
            return "Result [result=" + result + "]";
        }
        
        
    }
    
    public String result;
    public List<Result> results;
    
    @Override
    public String toString() {
        return "CreateUserEmailZipResponse [result=" + result + ", results=" + results + "]";
    }
}

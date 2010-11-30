package com.chompon.client;

import java.util.List;

public class CreateUserEmailZipResponse extends ChomponResponse {
    
    public static class Result {
        public String result;

        @Override
        public String toString() {
            return "Result [result=" + result + "]";
        }
    }

    public List<Result> results;
    
    @Override
    public String toString() {
        return "CreateUserEmailZipResponse [result=" + result + ", results=" + results + "]";
    }
}

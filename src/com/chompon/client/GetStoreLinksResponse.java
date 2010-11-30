package com.chompon.client;

import java.util.List;

public class GetStoreLinksResponse extends ChomponResponse {
    
    public static class Link {
        public String type;
        public String value;
        
        @Override
        public String toString() {
            return "Link [type=" + type + ", value=" + value + "]";
        }
    }
    
    public List<Link> results;
    
    @Override
    public String toString() {
        return "GetStoreLinksResponse [result=" + result + ", results=" + results + "]";
    }
}

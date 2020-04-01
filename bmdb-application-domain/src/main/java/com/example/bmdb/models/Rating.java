package com.example.bmdb.models;

import java.util.HashMap;
import java.util.Map;


public enum Rating {
    BAD(1), AVERAGE(3), GOOD(5);

    public final int rate;
    private Rating(int rate) {
        this.rate=rate;
    }
    private static final Map<Rating, Integer> BY_RATE=new HashMap<>();
    static{
        for(com.example.bmdb.models.Rating r: values()){
            BY_RATE.put(r, r.rate);
        }
    }
    public static int valueOfRating(Rating rating){
        return BY_RATE.get(rating);
    }
}
package com.crs.flipkart.utils;

import com.crs.flipkart.bean.PairPOJO;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static List<PairPOJO> convertListOfPairToJson(List<Pair<String, String>> t){
        List<PairPOJO> res = new ArrayList<PairPOJO>();
        for(Pair<String,String> p : t){
            res.add(new PairPOJO(p.getKey(),p.getValue()));
        }
        return res;
    }
}

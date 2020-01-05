package com.deep.dbdesign.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deep on 2019/12/30 21:08
 */
public class Tools {

    public static Map<String, String> toMap(String key, String value) {
        Map<String,String> map=new HashMap<>();
        map.put(key,value);
        return map;
    }
}

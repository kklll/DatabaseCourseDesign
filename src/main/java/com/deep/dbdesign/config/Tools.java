package com.deep.dbdesign.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deep on 2019/12/30 21:08
 */


//将普通请求转换成Map用来返回的工具
public class Tools {
    public static Map<String, String> toMap(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}

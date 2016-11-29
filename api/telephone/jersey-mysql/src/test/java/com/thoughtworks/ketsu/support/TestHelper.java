package com.thoughtworks.ketsu.support;

import com.thoughtworks.ketsu.domain.Card;

import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    public static final String ID = "0";
    public static final String NUMBER = "12345678901";
    public static final double ROAMING_RATES = 1;
    public static final Card otherCard = new Card("1", "09876543211");


    private static int auto_increment_key = 1;

    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

    public static Map<String, Object> userMap(String email, String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
            put("email", email);
        }};
    }

}

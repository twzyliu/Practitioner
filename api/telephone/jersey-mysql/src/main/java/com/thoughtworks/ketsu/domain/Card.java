package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.infrastructure.records.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 29/11/16.
 */
public class Card implements Record {
    private String id;
    private String number;

    public Card(String id, String number) {
        this.id = id;
        this.number = number;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("number", number);
        hashMap.put("url",routes.cardUrl(this));
        return hashMap;
    }

    public String getId() {
        return id;
    }
}

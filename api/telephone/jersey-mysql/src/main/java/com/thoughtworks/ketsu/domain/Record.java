package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 29/11/16.
 */
public class Record implements com.thoughtworks.ketsu.infrastructure.records.Record{
    private String id;
    private Card card;


    public Record(HashMap<String, Object> info) {
        this.id = info.getOrDefault("id","").toString();
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("url",routes.recordUrl(this));
        return hashMap;
    }

    public String getId() {
        return id;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}

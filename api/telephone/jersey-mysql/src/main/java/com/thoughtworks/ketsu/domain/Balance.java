package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 02/12/16.
 */
public class Balance implements com.thoughtworks.ketsu.infrastructure.records.Record{
    private String id;
    private Card card;

    public Balance(String id, Card card) {
        this.id = id;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("url", routes.balanceUrl(this));
        return map;
    }
}

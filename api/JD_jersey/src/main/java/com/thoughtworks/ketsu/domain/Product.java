package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.infrastructure.records.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class Product implements Record{
    private Integer id;
    private Integer uid;

    public Product(Integer id, Integer uid) {
        this.id = id;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUid() {
        return uid;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("url", routes.productUrl(this));
        return map;
    }
}

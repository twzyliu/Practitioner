package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.api.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class Refund implements Record{
    private Integer id;
    private Integer uid;
    private Integer roid;

    public Refund(Integer id, Integer uid, Integer roid) {
        this.id = id;
        this.uid = uid;
        this.roid = roid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getRoid() {
        return roid;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("url", routes.refundUrl(this));
        return map;
    }

}

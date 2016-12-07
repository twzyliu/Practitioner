package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.infrastructure.records.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class Payment implements Record {
    private Integer id;
    private Integer oid;
    private Integer uid;


    public Payment(Integer id, Integer oid, Integer uid) {
        this.id = id;
        this.oid = oid;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOid() {
        return oid;
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
        map.put("url", routes.paymentUrl(this));
        return map;
    }
}

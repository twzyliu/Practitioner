package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.infrastructure.records.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class Payment implements Record {
    private long id;
    private Order order;

    public Payment(long id, Order order) {
        this.id = id;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
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

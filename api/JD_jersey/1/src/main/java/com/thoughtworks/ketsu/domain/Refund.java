package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.api.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class Refund implements Record{
    private long id;
    private RefundOrder refundOrder;

    public Refund(long id, RefundOrder refundOrder) {
        this.id = id;
        this.refundOrder = refundOrder;
    }

    public RefundOrder getRefundOrder() {
        return refundOrder;
    }

    public long getId() {
        return id;
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

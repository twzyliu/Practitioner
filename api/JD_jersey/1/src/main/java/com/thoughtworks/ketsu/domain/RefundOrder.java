package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.api.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 23/11/16.
 */
public class RefundOrder implements Record {
    private long id;
    private User user;

    public RefundOrder(long id, User user) {
        this.id = id;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("url", routes.refundOrderUrl(this));
        return map;
    }
}

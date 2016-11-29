package com.thoughtworks.ketsu.domain;

import com.thoughtworks.ketsu.api.jersey.Routes;
import com.thoughtworks.ketsu.infrastructure.records.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 29/11/16.
 */
public class Contract implements Record{

    private double roamingRates = 0;
    private double longDistanceTariff = 0;
    private double localTariff = 0;
    private Card card;

    public Contract(Card card) {
        this.card = card;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("roamingRates", roamingRates);
        hashMap.put("longDistanceTariff",longDistanceTariff );
        hashMap.put("localTariff", localTariff);
        hashMap.put("url", routes.contractUrl(card));
        return hashMap;
    }

    public void setRoamingRates(double roamingRates) {
        this.roamingRates = roamingRates;
    }

    public void setLongDistanceTariff(double longDistanceTariff) {
        this.longDistanceTariff = longDistanceTariff;
    }

    public void setLocalTariff(double localTariff) {
        this.localTariff = localTariff;
    }
}

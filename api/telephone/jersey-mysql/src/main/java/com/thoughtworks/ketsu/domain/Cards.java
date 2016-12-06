package com.thoughtworks.ketsu.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zyongliu on 29/11/16.
 */
public interface Cards {
    Card getCard(String cid);

    List<Bill> getAllBills(String id);

    Bill getBill(String bid);

    Payment createPayment(Card card, HashMap<String, Object> info);
}

package com.thoughtworks.ketsu.support;

import com.thoughtworks.ketsu.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public abstract class TestHelper {
    public static String USERNAME_A = "A";
    public static String USERNAME_B = "B";
    public static Integer ORDERID_1 = 1;
    public static Integer ORDERID_2 = 2;
    public static Integer REFUND_ORDERID_1 = 1;
    public static Integer REFUND_ORDERID_2 = 2;
    public static Integer PRODUCT_ID_1 = 1;
    public static Integer PRODUCT_ID_2 = 2;
    public static Integer REFUND_1 = 1;
    public static Integer ORDER_ID = 100;
    public static Integer REFUND_ID = 200;

    public static User user = new User(0, USERNAME_A);
    public static User otherUser = new User(1, USERNAME_B);
    public static Order order = new Order(REFUND_ORDERID_1, user.getId());
    public static Order otherOrder = new Order(ORDERID_2, user.getId());
    public static List<Order> orderList = asList(order, otherOrder);
    public static Payment payment = new Payment(ORDERID_1, order.getId(), user.getId());
    public static RefundOrder refundOrder = new RefundOrder(REFUND_ORDERID_1, user.getId());
    public static RefundOrder otherRefundOrder = new RefundOrder(REFUND_ORDERID_2, user.getId());
    public static List<RefundOrder> refundOrderList = asList(refundOrder, otherRefundOrder);
    public static Product product = new Product(PRODUCT_ID_1, user.getId());
    public static Product otherproduct = new Product(PRODUCT_ID_2, user.getId());
    public static List<Product> productList = asList(product, otherproduct);
    public static Refund refund = new Refund(REFUND_1, refundOrder.getUid(), refundOrder.getId());

    public static HashMap<String, Object> userInfo = new HashMap<String, Object>() {{
        put("username", USERNAME_A);
    }};


    public static Map<String, Object> deployment(String appName, String releaseId) {
        return new HashMap<String, Object>() {{
            put("app", String.format("http://service-api.tw.com/apps/%s", appName));
            put("release", String.format("http://service-api.tw.com/apps/%s/releases/%s", appName, releaseId));
        }};
    }

    public static Map<String, Object> stackMap(String id, String name) {
        Map<String, Object> stackMap = new HashMap<String, Object>() {{
            put("id", id);
            put("name", name);
        }};
        return stackMap;
    }

    public static Map<String, Object> userMap(String email, String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
            put("email", email);
        }};
    }
}

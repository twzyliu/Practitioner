package com.thoughtworks.ketsu.api.jersey;

import com.thoughtworks.ketsu.domain.*;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI userUrl(User user) {
        return URI.create(String.format("%susers/%s", baseUri, user.getUsername()));
    }

    public URI orderUrl(Order order) {
        return URI.create(String.format("%susers/%s/orders/%s", baseUri, order.getUid(), order.getId()));
    }

    public URI refundOrderUrl(RefundOrder refundOrder) {
        return URI.create(String.format("%susers/%s/refundorders/%s", baseUri, refundOrder.getUid(), refundOrder.getId()));
    }

    public URI productUrl(Product product) {
        return URI.create(String.format("%susers/%s/products/%s", baseUri, product.getUser().getUsername(), product.getId()));
    }

    public URI paymentUrl(Payment payment) {
        return URI.create(String.format("%susers/%s/orders/%s/payment", baseUri, payment.getUid(), payment.getOid()));
    }

    public URI refundUrl(Refund refund) {
        return URI.create(String.format("%susers/%s/refundorders/%s/refund", baseUri, refund.getUid(), refund.getRoid()));
    }
}

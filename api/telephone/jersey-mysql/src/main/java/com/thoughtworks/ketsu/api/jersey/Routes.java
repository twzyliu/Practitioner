package com.thoughtworks.ketsu.api.jersey;

import com.thoughtworks.ketsu.domain.Balance;
import com.thoughtworks.ketsu.domain.Bill;
import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.domain.Record;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

    public URI cardUrl(Card card) {
        return URI.create(String.format("%scards/%s", baseUri, card.getId()));
    }

    public URI contractUrl(Card card) {
        return URI.create(String.format("%scards/%s/contract", baseUri, card.getId()));
    }

    public URI recordUrl(Record record) {
        return URI.create(String.format("%scards/%s/records/%s", baseUri, record.getCard().getId(), record.getId()));
    }

    public URI billUrl(Bill bill) {
        return URI.create(String.format("%scards/%s/bills/%s", baseUri, bill.getCard().getId(), bill.getId()));
    }

    public URI balanceUrl(Balance balance) {
        return URI.create(String.format("%scards/%s/balance", baseUri, balance.getCard().getId()));

    }
}

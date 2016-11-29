package com.thoughtworks.ketsu.api.jersey;

import com.thoughtworks.ketsu.domain.Card;

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
}

package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 29/11/16.
 */
@RunWith(ApiTestRunner.class)
public class CardApiTest extends ApiSupport {
    @Test
    public void should_return_200_when_get_card_info() throws Exception {
        Response response = get("/cards/0");

        assertThat(response.getStatus(), is(200));
    }
}

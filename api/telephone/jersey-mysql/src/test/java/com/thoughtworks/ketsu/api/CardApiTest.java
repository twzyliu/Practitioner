package com.thoughtworks.ketsu.api;

import com.thoughtworks.ketsu.domain.Card;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 29/11/16.
 */
@RunWith(ApiTestRunner.class)
public class CardApiTest extends ApiSupport {

    private static final String ID = "0";
    private static final String NUMBER = "12345678901";
    private Card card;



    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        card = new Card(ID, NUMBER);
        when(cards.getCard(ID)).thenReturn(card);
        when(currentCard.getCurrentCard()).thenReturn(card);
    }

    @Test
    public void should_return_200_when_get_card_info() throws Exception {
        Response response = get("/cards/" + ID);
        Map map = response.readEntity(Map.class);

        assertThat(response.getStatus(), is(200));
        assertThat(map.getOrDefault("number", "").toString(), is(NUMBER));
        assertThat(map.getOrDefault("id", "").toString(), is(ID));
    }

    @Test
    public void should_return_404_when_get_wrong_card_info() throws Exception {
        Response response = get("/cards/a");

        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void should_return_404_when_get_other_card_info() throws Exception {
        when(currentCard.getCurrentCard()).thenReturn(new Card("1","09876543211"));
        Response response = get("/cards/" + ID);

        assertThat(response.getStatus(), is(404));
    }
}




















import core.GameMap;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;
import place.Place;
import place.StartingPoint;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 28/11/16.
 */
public class GameMapTest {

    private GameMap gameMap;
    private List<Place> places;

    @Before
    public void setUp() throws Exception {
        places = asList(new StartingPoint(), new EmptyLand(TestHelper.LAND_PRICE));
        gameMap = new GameMap(places);

    }

    @Test
    public void should_return_land_when_get_by_position() throws Exception {
        assertThat(gameMap.getPlace(0), is(places.get(0)));
    }
}

import cmdType.CmdType;
import core.GameMap;
import core.Player;
import item.Block;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;
import place.Hospital;
import place.Place;
import place.StartingPoint;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 28/11/16.
 */
public class GameMapTest {

    private GameMap gameMap;
    private List<Place> places;
    private Player player;

    @Before
    public void setUp() throws Exception {
        places = asList(new StartingPoint(), new EmptyLand(TestHelper.LAND_PRICE),new Hospital());
        gameMap = new GameMap(places);
        player = new Player(gameMap, CmdType.CMD_TYPES);
    }

    @Test
    public void should_return_land_when_get_by_position() throws Exception {
        assertThat(gameMap.getPlace(0), is(places.get(0)));
    }

    @Test
    public void should_stop_when_encounter_block() throws Exception {
        Place place = places.get(1);
        place.setTool(new Block());

        player.move();

        assertThat(player.getPosition(), is(1));
        assertNull(place.getTool());
    }
}

import cmd.Cmd;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.Place;

import java.util.List;
import java.util.Optional;

import static cmdType.CmdType.CMD_TYPES;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SellCmdTest {
    private Player player;
    private Place place;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        place = new Place();
        player = new Player(gameMap, CMD_TYPES);
        when(gameMap.getPlace(anyInt())).thenReturn(place);
    }

    @Test
    public void should_not_change_available_cmds_after_sell_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.BLOCK_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }
}

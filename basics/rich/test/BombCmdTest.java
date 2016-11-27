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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BombCmdTest {
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
    public void should_not_change_available_cmds_after_bomb_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.BOMB_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_change_toolsnum_and_landstatus_after_bomb_success() throws Exception {
        player.getBomb().setNum(TestHelper.ENOUGH_TOOLS);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.BOMB_CMD);
        int toolsNum = player.getToolsNum();

        player.execute(cmd);

        assertThat(player.getToolsNum(), is(toolsNum - 1));
        assertThat(place.getTool(), is(player.getBomb()));
    }

    @Test
    public void should_not_change_when_no_tool_to_user() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.BOMB_CMD);
        int toolsNum = player.getToolsNum();

        player.execute(cmd);

        assertThat(player.getToolsNum(), is(toolsNum));
        assertNull(place.getTool());
    }
}

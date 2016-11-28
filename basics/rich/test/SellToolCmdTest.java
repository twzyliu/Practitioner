import cmd.Cmd;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static cmdType.CmdType.CMD_TYPES;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SellToolCmdTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
    }

    @Test
    public void should_not_change_available_cmds_after_selltool_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.SELLTOOL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_change_toolsnum_and_point_after_selltool_success() throws Exception {
        player.getBlock().setNum(TestHelper.ENOUGH_TOOLS);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.SELLTOOL_CMD);
        int toolsNum = player.getToolsNum();
        int point = player.getPoint();

        player.execute(cmd);

        assertThat(player.getToolsNum(), is(toolsNum - 1));
        assertThat(player.getPoint(), is(point + TestHelper.TOOL_POINT));
    }

    @Test
    public void should_not_change_when_no_tool_to_sell() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.SELLTOOL_CMD);
        int toolsNum = player.getToolsNum();
        int point = player.getPoint();

        player.execute(cmd);

        assertThat(player.getToolsNum(), is(toolsNum));
        assertThat(player.getPoint(), is(point));
    }
}

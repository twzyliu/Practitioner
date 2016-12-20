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
public class QueryCmdTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
    }

    @Test
    public void should_not_change_available_cmds_after_query_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.QUERY_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }
}


import cmd.Cmd;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 25/11/16.
 */
public class CmdTest {

    private Player player;
    private Cmd cmd;
    private CmdType cmdType;
    private Cmd initMoneyCmd;
    private CmdType initMoneyCmdType;

    @Before
    public void setUp() throws Exception {
        cmdType = mock(CmdType.class);
        cmd = mock(Cmd.class);
        player = new Player(mock(GameMap.class),cmdType);
        when(cmdType.parse(TestHelper.RICH_CMD)).thenReturn(Optional.of(cmd));
        initMoneyCmdType = mock(CmdType.class);
        initMoneyCmd = mock(Cmd.class);
    }

    @Test
    public void should_return_initial_cmds_as_available_cmd() throws Exception {
        Optional<Cmd> rich = player.getAvailableCmd(TestHelper.RICH_CMD);

        assertThat(rich, is(Optional.of(cmd)));
    }

    @Test
    public void should_change_available_cmds_if_state_change() throws Exception {
        Optional<Cmd> rich = player.getAvailableCmd(TestHelper.RICH_CMD);
        when(rich.get().execute(eq(player), any())).thenReturn(asList(initMoneyCmdType));
        when(initMoneyCmdType.parse(TestHelper.INIT_MONEY_CMD)).thenReturn(Optional.of(initMoneyCmd));

        player.execute(rich);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.INIT_MONEY_CMD);

        assertThat(cmd, is(Optional.of(initMoneyCmd)));
    }


}


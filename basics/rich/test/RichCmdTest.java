import cmd.Cmd;
import cmdType.CmdType;
import core.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 28/11/16.
 */
public class RichCmdTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game(CmdType.CMD_TYPES);
    }

    @Test
    public void should_change_available_cmds_after_rich_cmd() throws Exception {
        Optional<Cmd> cmd = game.getAvailableCmd(TestHelper.RICH_CMD);
        List<CmdType> availableCmdType = game.getAvailableCmdType();

        game.execute(cmd);

        assertThat(game.getAvailableCmdType() != availableCmdType, is(true));
    }

    @Test
    public void should_change_available_cmds_after_initial_money() throws Exception {
        Optional<Cmd> cmd = game.getAvailableCmd(TestHelper.RICH_CMD);
        game.execute(cmd);
        List<CmdType> availableCmdType = game.getAvailableCmdType();

        Optional<Cmd> initMoneyCmd = game.getAvailableCmd(TestHelper.INIT_MONEY_CMD);
        game.execute(initMoneyCmd);

        assertThat(game.getAvailableCmdType() != availableCmdType, is(true));
    }
}

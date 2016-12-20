import cmd.Cmd;
import cmd.roll.YesToUpgrade;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;

import java.util.List;
import java.util.Optional;

import static cmdType.CmdType.CMD_TYPES;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 26/11/16.
 */
public class RollCmdOwnLandTest {
    private Player player;
    private EmptyLand ownLand;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
        ownLand = new EmptyLand(TestHelper.LAND_PRICE);
        ownLand.setOwner(player);
        when(gameMap.getPlace(anyInt())).thenReturn(ownLand);
    }

    @Test
    public void should_return_available_cmds_after_roll_to_ownland() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);

        assertThat(yes.get() instanceof YesToUpgrade, is(true));
    }

    @Test
    public void should_change_money_and_change_land_level_after_have_enough_money_and_land_level_to_sayYes() throws Exception {
        player.setMoney(TestHelper.ENOUGH_MONEY);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);
        int money = player.getMoney();
        int level = ownLand.getLevel();

        player.execute(yes);

        assertThat(player.getMoney(), is(money - ownLand.getPrice()));
        assertThat(ownLand.getLevel(), is(level + 1));
    }

    @Test
    public void should_not_change_when_no_enough_money_to_sayYes() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);
        int money = player.getMoney();
        int level = ownLand.getLevel();

        player.execute(yes);

        assertThat(player.getMoney(), is(money));
        assertThat(ownLand.getLevel(), is(level));
    }

    @Test
    public void should_not_change_when_land_level_is_maxlevel_to_sayYes() throws Exception {
        player.setMoney(TestHelper.ENOUGH_MONEY);
        ownLand.setLevel(EmptyLand.MAX_LEVEL);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);
        int money = player.getMoney();
        int level = ownLand.getLevel();

        player.execute(yes);

        assertThat(player.getMoney(), is(money));
        assertThat(ownLand.getLevel(), is(level));
    }

    @Test
    public void should_change_available_cmds_after_say_yes_or_no() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> no = player.getAvailableCmd(TestHelper.NO);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(no);

        assertThat(player.getAvailableCmdType() != availableCmdType, is(true));
    }

    @Test
    public void should_not_change_available_cmds_after_wrong_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> wrongCmd = player.getAvailableCmd(TestHelper.WRONG_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(wrongCmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));

    }
}

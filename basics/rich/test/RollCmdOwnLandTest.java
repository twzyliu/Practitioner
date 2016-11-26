import cmd.Cmd;
import cmd.roll.YesToUpgrade;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;

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
    private EmptyLand emptyLand;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
        emptyLand = new EmptyLand(TestHelper.LAND_PRICE);
        emptyLand.setOwner(player);
        when(gameMap.getPlace(anyInt())).thenReturn(emptyLand);
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
        int level = emptyLand.getLevel();

        player.execute(yes);

        assertThat(player.getMoney(), is(money - emptyLand.getPrice()));
        assertThat(emptyLand.getLevel(), is(level + 1));
    }

    @Test
    public void should_not_change_when_no_enough_money_to_sayYes() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);
        int money = player.getMoney();
        int level = emptyLand.getLevel();

        player.execute(yes);

        assertThat(player.getMoney(), is(money));
        assertThat(emptyLand.getLevel(), is(level));
    }
}

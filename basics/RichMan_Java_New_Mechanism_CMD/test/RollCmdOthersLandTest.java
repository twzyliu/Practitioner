import cmd.Cmd;
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
public class RollCmdOthersLandTest {
    private Player player;
    private EmptyLand othersLand;
    private Player others;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
        others = new Player(gameMap, CMD_TYPES);
        othersLand = new EmptyLand(TestHelper.LAND_PRICE);
        othersLand.setOwner(others);
        when(gameMap.getPlace(anyInt())).thenReturn(othersLand);
    }

    @Test
    public void should_not_change_available_cmds_after_roll_to_othersland() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_change_my_money_and_others_money_when_have_enough_money_to_pay_bill() throws Exception {
        player.setMoney(TestHelper.ENOUGH_MONEY);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        int money = player.getMoney();
        int othersMoney = others.getMoney();

        player.execute(cmd);

        assertThat(player.getMoney(), is(money - othersLand.getBill()));
        assertThat(others.getMoney(), is(othersMoney + othersLand.getBill()));
    }

    @Test
    public void should_gameover_when_no_enough_money_to_pay_bill() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);

        player.execute(cmd);

        assertThat(player.isGameOver(), is(true));
    }
}

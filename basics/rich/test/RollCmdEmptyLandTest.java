import cmd.Cmd;
import cmd.roll.YesToBuy;
import cmdType.roll.RollCmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.EmptyLand;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 25/11/16.
 */
public class RollCmdEmptyLandTest {

    private Player player;
    private EmptyLand emptyLand;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        RollCmdType rollCmdType = new RollCmdType();
        player = new Player(gameMap, rollCmdType);
        emptyLand = new EmptyLand(TestHelper.LAND_PRICE);
        when(gameMap.getPlace(anyInt())).thenReturn(emptyLand);
    }

    @Test
    public void should_return_available_cmds_after_roll_to_emptyland() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);

        assertThat(yes.get() instanceof YesToBuy, is(true));
    }

    @Test
    public void should_change_money_and_add_land_and_change_land_owner_after_have_enough_money_to_sayYes() throws Exception {
        player.setMoney(TestHelper.ENOUGH_MONEY);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        Optional<Cmd> yes = player.getAvailableCmd(TestHelper.YES);
        int money = player.getMoney();
        int landsNum = player.getLands().size();

        player.execute(yes);

        assertThat(player.getMoney(), is(money - emptyLand.getPrice()));
        assertThat(player.getLands().size(), is(landsNum + 1));
        assertThat(emptyLand.getOwner(), is(player));
    }
}

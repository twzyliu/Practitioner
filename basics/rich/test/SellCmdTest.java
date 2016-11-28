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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SellCmdTest {
    private Player player;
    private EmptyLand emptyLand;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        emptyLand = new EmptyLand(TestHelper.LAND_PRICE);
        player = new Player(gameMap, CMD_TYPES);
        when(gameMap.getPlace(anyInt())).thenReturn(emptyLand);
    }

    @Test
    public void should_not_change_available_cmds_after_sell_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.SELL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_change_landnum_and_landowner_and_landlevel_and_money_after_sell_success() throws Exception {
        emptyLand.setLevel(EmptyLand.MAX_LEVEL);
        player.getLands().add(emptyLand);
        emptyLand.setOwner(player);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.SELL_CMD);
        int landsNum = player.getLands().size();
        int sellPrice = emptyLand.getSellPrice();
        int money = player.getMoney();

        player.execute(cmd);

        assertThat(player.getLands().size(), is(landsNum - 1));
        assertThat(player.getMoney(), is(money + sellPrice));
        assertThat(emptyLand.getLevel(), is(0));
        assertNull(emptyLand.getOwner());
    }
}

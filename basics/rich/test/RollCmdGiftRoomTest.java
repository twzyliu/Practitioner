import cmd.Cmd;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import org.junit.Before;
import org.junit.Test;
import place.GiftRoom;

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
public class RollCmdGiftRoomTest {
    private Player player;
    private GiftRoom giftRoom;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
        giftRoom = new GiftRoom();
        when(gameMap.getPlace(anyInt())).thenReturn(giftRoom);
    }

    @Test
    public void should_return_available_cmds_after_roll_to_giftroom() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType() != availableCmdType, is(true));
    }

    @Test
    public void should_change_money_when_chose_one() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        int money = player.getMoney();

        Optional<Cmd> choseOne = player.getAvailableCmd(TestHelper.CHOSE_ONE);
        player.execute(choseOne);

        assertThat(player.getMoney(), is(money + GiftRoom.giftMoney));
    }

    @Test
    public void should_change_point_when_chose_two() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        int point = player.getPoint();

        Optional<Cmd> choseTwo = player.getAvailableCmd(TestHelper.CHOSE_TWO);
        player.execute(choseTwo);

        assertThat(player.getPoint(), is(point + GiftRoom.giftPoint));
    }

    @Test
    public void should_get_god_when_chose_three() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);

        Optional<Cmd> choseThree = player.getAvailableCmd(TestHelper.CHOSE_THREE);
        player.execute(choseThree);

        assertThat(player.getGodDays(), is(GiftRoom.giftGodDays));
    }

    @Test
    public void should_change_available_cmds_after_chose_or_wrong_cmd() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        Optional<Cmd> wrongCmd = player.getAvailableCmd(TestHelper.WRONG_CMD);
        player.execute(wrongCmd);

        assertThat(player.getAvailableCmdType() != availableCmdType, is(true));
    }
}

import cmd.Cmd;
import cmdType.CmdType;
import core.GameMap;
import core.Player;
import item.Block;
import item.Bomb;
import item.Item;
import item.Robot;
import org.junit.Before;
import org.junit.Test;
import place.ToolRoom;

import java.util.List;
import java.util.Optional;

import static cmdType.CmdType.CMD_TYPES;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zyongliu on 27/11/16.
 */
public class RollCmdToolRoomTest {
    private Player player;
    private ToolRoom toolRoom;

    @Before
    public void setUp() throws Exception {
        GameMap gameMap = mock(GameMap.class);
        player = new Player(gameMap, CMD_TYPES);
        toolRoom = new ToolRoom();
        when(gameMap.getPlace(anyInt())).thenReturn(toolRoom);
    }

    @Test
    public void should_not_change_available_cmds_after_roll_to_toolroom_and_no_enough_point() throws Exception {
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_return_available_cmds_after_roll_to_toolroom_and_have_enough_point() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        player.execute(cmd);

        assertThat(player.getAvailableCmdType() != availableCmdType, is(true));
    }

    @Test
    public void should_change_point_and_toolsnum_when_have_enough_point_to_chose_one() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        int point = player.getPoint();
        Block block = player.getBlock();
        int num = block.getNum();

        Optional<Cmd> choseOne = player.getAvailableCmd(TestHelper.CHOSE_ONE);
        player.execute(choseOne);

        assertThat(player.getPoint(), is(point - block.getPoint()));
        assertThat(block.getNum(), is(num + 1));
    }

    @Test
    public void should_change_point_and_toolsnum_when_have_enough_point_to_chose_two() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        int point = player.getPoint();
        Robot robot = player.getRobot();
        int num = robot.getNum();

        Optional<Cmd> choseTwo = player.getAvailableCmd(TestHelper.CHOSE_TWO);
        player.execute(choseTwo);

        assertThat(player.getPoint(), is(point - robot.getPoint()));
        assertThat(robot.getNum(), is(num + 1));
    }

    @Test
    public void should_change_point_and_toolsnum_when_have_enough_point_to_chose_three() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        int point = player.getPoint();
        Bomb bomb = player.getBomb();
        int num = bomb.getNum();

        Optional<Cmd> choseThee = player.getAvailableCmd(TestHelper.CHOSE_THREE);
        player.execute(choseThee);

        assertThat(player.getPoint(), is(point - bomb.getPoint()));
        assertThat(bomb.getNum(), is(num + 1));
    }

    @Test
    public void should_not_change_when_no_enough_point_or_space_to_buy() throws Exception {
        player.setPoint(Item.CHEAPEST);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        List<CmdType> availableCmdType = player.getAvailableCmdType();
        int toolsNum = player.getToolsNum();

        Optional<Cmd> choseOne = player.getAvailableCmd(TestHelper.CHOSE_ONE);
        player.execute(choseOne);
        assertThat(player.getAvailableCmdType(), is(availableCmdType));
        assertThat(player.getToolsNum(), is(toolsNum));

        player.setPoint(TestHelper.ENOUGH_POINT);
        player.getBomb().setNum(Player.MAX_ITEMS);
        int point = player.getPoint();
        Optional<Cmd> choseThree = player.getAvailableCmd(TestHelper.CHOSE_THREE);
        player.execute(choseThree);
        assertThat(player.getAvailableCmdType(), is(availableCmdType));
        assertThat(player.getPoint(), is(point));
    }

    @Test
    public void should_not_change_available_cmds_after_chose_or_wrong_cmd() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        Optional<Cmd> wrongCmd = player.getAvailableCmd(TestHelper.WRONG_CMD);
        player.execute(wrongCmd);

        assertThat(player.getAvailableCmdType(), is(availableCmdType));
    }

    @Test
    public void should_change_available_cmds_after_chose_exit_cmd() throws Exception {
        player.setPoint(TestHelper.ENOUGH_POINT);
        Optional<Cmd> cmd = player.getAvailableCmd(TestHelper.ROLL_CMD);
        player.execute(cmd);
        List<CmdType> availableCmdType = player.getAvailableCmdType();

        Optional<Cmd> exitCmd = player.getAvailableCmd(TestHelper.EXIT_CMD);
        player.execute(exitCmd);

        assertThat(player.getAvailableCmdType() != availableCmdType, is(true));
    }
}











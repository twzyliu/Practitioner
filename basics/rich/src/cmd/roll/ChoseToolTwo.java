package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import item.Robot;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolTwo implements Cmd{
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Robot robot = player.getRobot();
        player.setPoint(player.getPoint() - robot.getPoint());
        robot.setNum(robot.getNum() + 1);
        return asList();
    }
}

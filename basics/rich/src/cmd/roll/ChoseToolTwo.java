package cmd.roll;

import cmd.Cmd;
import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Robot;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolTwo implements Cmd{
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Robot robot = player.getRobot();
        if (player.getPoint() >= robot.getPoint() && player.getToolsNum() < Player.MAX_ITEMS) {
            player.setPoint(player.getPoint() - robot.getPoint());
            robot.setNum(robot.getNum() + 1);
        }
        return asList();
    }
}

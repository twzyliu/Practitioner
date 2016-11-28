package cmd;

import cmdType.CmdType;
import core.Player;
import item.Robot;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class RobotCmd implements Cmd {
    @Override
    public List<CmdType> execute(Player player, List<CmdType> initialCmdType) {
        Robot robot = player.getRobot();
        robot.use(player, 0);
        return initialCmdType;
    }
}

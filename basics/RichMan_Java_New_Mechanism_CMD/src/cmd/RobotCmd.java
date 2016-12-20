package cmd;

import cmdType.CmdType;
import core.Player;
import core.WithCommandCapability;
import item.Robot;

import java.util.List;

/**
 * Created by zyongliu on 27/11/16.
 */
public class RobotCmd implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        Player player = (Player) withCommandCapability;
        Robot robot = player.getRobot();
        robot.use(player, 0);
        return initialCmdType;
    }
}

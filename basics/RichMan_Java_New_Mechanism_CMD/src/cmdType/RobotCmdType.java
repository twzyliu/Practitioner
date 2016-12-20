package cmdType;

import cmd.Cmd;
import cmd.RobotCmd;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class RobotCmdType implements CmdType {
    private static final String ROBOT_CMD = "robot";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(ROBOT_CMD)) {
            return Optional.of(new RobotCmd());
        } else {
            return Optional.empty();
        }
    }
}

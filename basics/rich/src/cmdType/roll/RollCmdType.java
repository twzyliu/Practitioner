package cmdType.roll;

import cmd.Cmd;
import cmd.roll.RollCmd;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public class RollCmdType implements CmdType {

    public static final String ROLL_CMD = "roll";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(ROLL_CMD)) {
            return Optional.of(new RollCmd());
        } else {
            return Optional.empty();
        }
    }
}

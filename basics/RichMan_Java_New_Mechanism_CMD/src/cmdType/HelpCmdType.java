package cmdType;

import cmd.Cmd;
import cmd.HeloCmd;

import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class HelpCmdType implements CmdType {

    public static final String HELP_CMD = "help";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(HELP_CMD)) {
            return Optional.of(new HeloCmd());
        } else {
            return Optional.empty();
        }
    }
}

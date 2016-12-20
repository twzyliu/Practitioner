package cmdType;

import cmd.Cmd;
import cmd.RichCmd;

import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class RichCmdType implements CmdType {

    public static final String RICH_CMD = "rich";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(RICH_CMD)) {
            return Optional.of(new RichCmd());
        } else {
            return Optional.empty();
        }
    }
}

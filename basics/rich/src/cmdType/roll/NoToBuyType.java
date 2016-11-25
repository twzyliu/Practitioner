package cmdType.roll;

import cmd.Cmd;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public class NoToBuyType implements CmdType {
    @Override
    public Optional<Cmd> parse(String cmd) {
        return null;
    }
}

package cmdType.roll;

import cmd.Cmd;
import cmd.roll.NoToBuy;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public class NoToBuyType implements CmdType {
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(NO)) {
            return Optional.of(new NoToBuy());
        } else {
            return Optional.empty();
        }
    }
}

package cmdType.roll;

import cmd.Cmd;
import cmd.roll.NoToBuy;
import cmd.roll.NoToUpgrade;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 26/11/16.
 */
public class NoToUpgradeType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(NO)) {
            return Optional.of(new NoToUpgrade());
        } else {
            return Optional.empty();
        }
    }
}

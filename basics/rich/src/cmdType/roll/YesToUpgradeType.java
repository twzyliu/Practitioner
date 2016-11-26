package cmdType.roll;

import cmd.Cmd;
import cmd.roll.YesToUpgrade;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 26/11/16.
 */
public class YesToUpgradeType implements CmdType {
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(YES)) {
            return Optional.of(new YesToUpgrade());
        } else {
            return Optional.empty();
        }
    }
}

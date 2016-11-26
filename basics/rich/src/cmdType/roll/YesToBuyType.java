package cmdType.roll;

import cmd.Cmd;
import cmd.roll.YesToBuy;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public class YesToBuyType implements CmdType {
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(YES)) {
            return Optional.of(new YesToBuy());
        } else {
            return Optional.empty();
        }
    }
}

package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseGiftTwo;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftTwoType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_TWO)) {
            return Optional.of(new ChoseGiftTwo());
        } else {
            return Optional.empty();
        }
    }
}

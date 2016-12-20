package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseToolTwo;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolTwoType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_TWO)) {
            return Optional.of(new ChoseToolTwo());
        } else {
            return Optional.empty();
        }
    }
}

package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseToolOne;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolOneType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_ONE)) {
            return Optional.of(new ChoseToolOne());
        } else {
            return Optional.empty();
        }
    }
}

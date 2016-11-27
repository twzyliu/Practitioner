package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseToolOne;
import cmd.roll.ChoseToolThree;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolThreeType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_THREE)) {
            return Optional.of(new ChoseToolThree());
        } else {
            return Optional.empty();
        }
    }
}

package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseToolExit;
import cmd.roll.ChoseToolThree;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class ChoseToolExitType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(EXIT)) {
            return Optional.of(new ChoseToolExit());
        } else {
            return Optional.empty();
        }
    }
}

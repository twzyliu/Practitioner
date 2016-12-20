package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseGiftOne;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftOneType implements CmdType{

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_ONE)) {
            return Optional.of(new ChoseGiftOne());
        } else {
            return Optional.empty();
        }
    }
}

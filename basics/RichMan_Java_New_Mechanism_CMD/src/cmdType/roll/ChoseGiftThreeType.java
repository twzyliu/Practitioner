package cmdType.roll;

import cmd.Cmd;
import cmd.roll.ChoseGiftThree;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 26/11/16.
 */
public class ChoseGiftThreeType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(CHOSE_THREE)) {
            return Optional.of(new ChoseGiftThree());
        } else {
            return Optional.empty();
        }
    }
}

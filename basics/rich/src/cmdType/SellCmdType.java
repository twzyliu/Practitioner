package cmdType;

import cmd.Cmd;
import cmd.SellCmd;

import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SellCmdType implements CmdType {

    public static final String SELL_CMD = "sell ";
    private int position = 0;

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().contains(SELL_CMD) && checkCmd(cmd)) {
            return Optional.of(new SellCmd().setPosition(position));
        }
        return Optional.empty();
    }

    public boolean checkCmd(String cmd) {
        try {
            position = Integer.parseInt(asList(cmd.split(" ")).get(1));
            return (asList(cmd.split(" ")).size() == 2);
        } catch (Exception e) {
            return false;
        }
    }
}

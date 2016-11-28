package cmdType;

import cmd.BlockCmd;
import cmd.Cmd;

import java.util.Optional;

import static java.lang.Math.abs;
import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BlockCmdType implements CmdType {

    public static final String BLOCK_CMD = "block ";
    private int step = 0;

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().contains(BLOCK_CMD) && checkCmd(cmd)) {
            return Optional.of(new BlockCmd().setStep(step));
        }
        return Optional.empty();
    }

    public boolean checkCmd(String cmd) {
        try {
            step = Integer.parseInt(asList(cmd.split(" ")).get(1));
            return (asList(cmd.split(" ")).size() == 2 && abs(step) < 11);
        } catch (Exception e) {
            return false;
        }
    }
}

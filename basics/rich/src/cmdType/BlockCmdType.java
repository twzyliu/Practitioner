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

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().contains(BLOCK_CMD) && checkCmd(cmd)) {
            return Optional.of(new BlockCmd());
        }
        return Optional.empty();
    }

    public boolean checkCmd(String cmd) {
        return (asList(cmd.split(" ")).size() == 2 && abs(Integer.parseInt(asList(cmd.split(" ")).get(1))) < 11);
    }
}

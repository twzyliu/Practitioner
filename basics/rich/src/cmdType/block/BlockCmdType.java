package cmdType.block;

import cmd.Cmd;
import cmd.block.BlockCmd;
import cmdType.CmdType;

import java.util.Optional;

/**
 * Created by zyongliu on 27/11/16.
 */
public class BlockCmdType implements CmdType {

    public static final String BLOCK_CMD = "block ";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().contains(BLOCK_CMD)) {
            return Optional.of(new BlockCmd());
        } else {
            return Optional.empty();
        }
    }
}

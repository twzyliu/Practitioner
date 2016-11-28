package cmdType;

import cmd.Cmd;

import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitPlayerCmdType implements CmdType{
    @Override
    public Optional<Cmd> parse(String cmd) {
        return null;
    }
}

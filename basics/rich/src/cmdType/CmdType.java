package cmdType;

import cmd.Cmd;

import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public interface CmdType {
    Optional<Cmd> parse(String cmd);
}

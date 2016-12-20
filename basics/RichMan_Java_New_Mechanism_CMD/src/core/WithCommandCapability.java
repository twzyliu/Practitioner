package core;

import cmd.Cmd;
import cmdType.CmdType;

import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public interface WithCommandCapability {
    Optional<Cmd> getAvailableCmd(String cmd);

    void execute(Optional<Cmd> cmd);

    List<CmdType> getAvailableCmdType();
}

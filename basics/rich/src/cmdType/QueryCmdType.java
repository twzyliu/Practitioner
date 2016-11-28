package cmdType;

import cmd.Cmd;
import cmd.QueryCmd;

import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class QueryCmdType implements CmdType {

    public static final String QUERY_CMD = "query";

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().equals(QUERY_CMD)) {
            return Optional.of(new QueryCmd());
        } else {
            return Optional.empty();
        }
    }
}

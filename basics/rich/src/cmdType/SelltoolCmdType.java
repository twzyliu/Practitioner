package cmdType;

import cmd.Cmd;
import cmd.SelltoolCmd;

import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 28/11/16.
 */
public class SelltoolCmdType implements CmdType {
    public static final String SELLTOOL_CMD = "selltool ";
    private int toolNum = 0;

    @Override
    public Optional<Cmd> parse(String cmd) {
        if (cmd.toLowerCase().contains(SELLTOOL_CMD) && checkCmd(cmd)) {
            return Optional.of(new SelltoolCmd().setToolNum(toolNum));
        }
        return Optional.empty();
    }

    public boolean checkCmd(String cmd) {
        try {
            toolNum = Integer.parseInt(asList(cmd.split(" ")).get(1));
            return (asList(cmd.split(" ")).size() == 2);
        } catch (Exception e) {
            return false;
        }
    }
}

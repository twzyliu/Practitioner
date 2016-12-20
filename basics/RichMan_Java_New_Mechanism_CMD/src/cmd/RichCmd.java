package cmd;

import cmdType.CmdType;
import cmdType.InitMoneyCmdType;
import core.WithCommandCapability;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 28/11/16.
 */
public class RichCmd implements Cmd {
    @Override
    public List<CmdType> execute(WithCommandCapability withCommandCapability, List<CmdType> initialCmdType) {
        return asList(new InitMoneyCmdType());
    }
}

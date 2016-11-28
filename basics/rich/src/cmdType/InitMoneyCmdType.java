package cmdType;

import cmd.Cmd;
import cmd.InitMoneyCmd;
import cmd.RichCmd;

import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class InitMoneyCmdType implements CmdType {
    private int initMoney = 10000;

    @Override
    public Optional<Cmd> parse(String cmd) {
        try {
            initMoney = Integer.parseInt(cmd);
            return Optional.of(new InitMoneyCmd().setInitMoney(initMoney));
        } catch (Exception e) {
            return Optional.of(new RichCmd()) ;
        }
    }
}

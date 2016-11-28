package core;

import cmd.Cmd;
import cmd.WrongCmd;
import cmdType.CmdType;

import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 28/11/16.
 */
public class Game implements WithCommandCapability{
    private List<CmdType> availableCmdType;
    private List<CmdType> initialCmdType;
    private int initMoney;

    public Game(List<CmdType> initialCmdType) {
        this.initialCmdType = initialCmdType;
        this.availableCmdType = this.initialCmdType;
    }

    @Override
    public Optional<Cmd> getAvailableCmd(String cmd) {
        try {
            return availableCmdType.stream().map(cmdType -> cmdType.parse(cmd)).filter(Optional::isPresent).findFirst().get();
        } catch (Exception e) {
            return Optional.of(new WrongCmd());
        }
    }

    @Override
    public void execute(Optional<Cmd> cmd) {
        List<CmdType> execute = cmd.get().execute(this, initialCmdType);
        this.availableCmdType = execute.size() > 0 ? execute : this.availableCmdType;
    }

    @Override
    public List<CmdType> getAvailableCmdType() {
        return availableCmdType;
    }

    public void setInitMoney(int initMoney) {
        this.initMoney = initMoney;
    }
}

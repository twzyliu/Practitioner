package core;

import cmd.Cmd;
import cmd.WrongCmd;
import cmdType.CmdType;
import place.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by zyongliu on 25/11/16.
 */
public class Player {

    private List<CmdType> availableCmdType;
    private List<CmdType> initialCmdType;
    private GameMap gameMap;
    private int position = 0;
    private int money = 0;
    private int point = 0;
    private List<Place> lands = new ArrayList<>();

    public Player(GameMap gameMap, List<CmdType> cmdTypes) {
        this.initialCmdType = cmdTypes;
        this.availableCmdType = this.initialCmdType;
        this.gameMap = gameMap;
    }

    public Optional<Cmd> getAvailableCmd(String cmd) {
        try {
            return availableCmdType.stream().map(cmdType -> cmdType.parse(cmd)).filter(Optional::isPresent).findFirst().get();
        } catch (Exception e) {
            return Optional.of(new WrongCmd());
        }
    }

    public void execute(Optional<Cmd> cmd) {
        List<CmdType> execute = cmd.get().execute(this, initialCmdType);
        this.availableCmdType = execute.size() > 0 ? execute : this.availableCmdType;
    }

    public List<CmdType> getAvailableCmdType() {
        return availableCmdType;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Place move() {
        position = getGameMap().move(position);
        return getPlace();
    }

    public Place getPlace() {
        return getGameMap().getPlace(position);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Place> getLands() {
        return lands;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

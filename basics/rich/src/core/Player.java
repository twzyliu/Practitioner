package core;

import cmd.Cmd;
import cmdType.CmdType;
import place.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class Player {

    private List<CmdType> availableCmdType;
    private List<CmdType> initialCmdType;
    private GameMap gameMap;
    private int position = 0;
    private int money = 0;
    private List<Place> lands = new ArrayList<>();

    public Player(GameMap gameMap, CmdType... cmdTypes) {
        this.initialCmdType = asList(cmdTypes);
        this.availableCmdType = this.initialCmdType;
        this.gameMap = gameMap;
    }

    public Optional<Cmd> getAvailableCmd(String cmd) {
        return availableCmdType.stream().map(cmdType -> cmdType.parse(cmd)).filter(Optional::isPresent).findFirst().get();
    }

    public void execute(Optional<Cmd> cmd) {
        this.availableCmdType = cmd.get().execute(this, initialCmdType);
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
}

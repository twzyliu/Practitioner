package core;

import cmd.Cmd;
import cmd.WrongCmd;
import cmdType.CmdType;
import item.Block;
import item.Bomb;
import item.Item;
import item.Robot;
import place.Hospital;
import place.Place;
import place.Prison;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by zyongliu on 25/11/16.
 */
public class Player implements WithCommandCapability {

    public static final int MAX_ITEMS = 10;
    private List<CmdType> availableCmdType;
    private List<CmdType> initialCmdType;
    private GameMap gameMap;
    private int position = 0;
    private int money = 0;
    private int point = 0;
    private List<Place> lands = new ArrayList<>();
    private int godDays = 0;
    private int prisonDays = 0;
    private int hospitalDays = 0;
    private boolean isGameOver = false;
    private Block block = new Block();
    private Bomb bomb = new Bomb();
    private Robot robot = new Robot();
    private List<Item> toolList = asList(block, robot, bomb);

    public Player(GameMap gameMap, List<CmdType> cmdTypes) {
        this.initialCmdType = cmdTypes;
        this.availableCmdType = this.initialCmdType;
        this.gameMap = gameMap;
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

    public GameMap getGameMap() {
        return gameMap;
    }

    public Place move() {
        position = getGameMap().move(this, position);
        return getPlace();
    }

    public Place getPlace() {
        return getGameMap().getPlace(position);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            isGameOver = true;
        }
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

    public int getGodDays() {
        return godDays;
    }

    public void setGodDays(int godDays) {
        this.godDays = godDays;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getPrisonDays() {
        return prisonDays;
    }

    public void gotoPrison() {
        prisonDays = Prison.PRISON_DAYS;
    }

    public int getToolsNum() {
        return block.getNum() + robot.getNum() + bomb.getNum();
    }

    public Block getBlock() {
        return block;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getPosition() {
        return position;
    }

    public Item getTool(int num) {
        return toolList.get(num - 1);
    }

    public int getHospitalDays() {
        return hospitalDays;
    }

    public void gotoHospital() {
        hospitalDays = Hospital.HOSPITAL_DAYS;
    }
}

package ioc;

/**
 * Created by zyongliu on 18/12/16.
 */
public class OutputService {
    private HiService hiService;

    public String output(String name) {
        return "hi " + name;
    }
}

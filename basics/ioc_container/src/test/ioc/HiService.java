package ioc;

/**
 * Created by zyongliu on 18/12/16.
 */
public class HiService {
    private String name;
    private OutputService outputService;

    public String sayHi() {
        return outputService.output(name);
    }

}

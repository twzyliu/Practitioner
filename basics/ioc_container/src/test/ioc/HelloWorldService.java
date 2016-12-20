package ioc;

/**
 * Created by zyongliu on 16/12/16.
 */
public class HelloWorldService {
    private String words;

    public String hello() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}

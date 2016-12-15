/**
 * Created by zyongliu on 15/12/16.
 */
public class SampleServiceImpl implements SampleService {
    @Override
    public String getNameById(String userId) {
        return "hello " + userId;
    }
}

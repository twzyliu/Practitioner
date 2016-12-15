/**
 * Created by zyongliu on 15/12/16.
 */


public class SampleAction {
    private SampleService sampleService;
    private String userId;

    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public String getName() {
        return this.sampleService.getNameById(userId);
    }
}

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zyongliu on 15/12/16.
 */

public class SampleAction extends ActionSupport{
    private SampleService service;
    private String userId;
    private String name;

    public void setService(SampleService service) {
        this.service = service;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() {
        name = this.service.getNameById(userId);
        return SUCCESS;
    }

}

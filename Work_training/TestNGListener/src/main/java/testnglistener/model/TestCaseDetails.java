package testnglistener.model;

import java.util.List;

/**
 * Created by yrd on 2017/5/24.
 *
 */
public class TestCaseDetails {

    private String jiraId;
    private String tcClass;
    private String tcMethod;
    private List<String> arguments;

    public TestCaseDetails() {
        super();
    }

    public TestCaseDetails(String jiraId, String tcClass, String tcMethod, List<String> arguments) {
        super();
        this.jiraId = jiraId;
        this.tcClass = tcClass;
        this.tcMethod = tcMethod;
        this.arguments = arguments;
    }

    public String getJiraId() {
        return jiraId;
    }

    public void setJiraId(String jiraId) {
        this.jiraId = jiraId;
    }

    public String getTcClass() {
        return tcClass;
    }

    public void setTcClass(String tcClass) {
        this.tcClass = tcClass;
    }

    public String getTcMethod() {
        return tcMethod;
    }

    public void setTcMethod(String tcMethod) {
        this.tcMethod = tcMethod;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}

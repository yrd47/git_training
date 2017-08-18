package testnglistener.model;

import java.util.List;
/**
 * Created by yrd on 2017/5/24.
 *
 */
public class ResultDetails {

    private String suiteName;
    private String startTime;
    private String endTime;
    private String host;
    private String status;
    private TestCaseDetails testCaseDetails;
    private List<String> logs;
    private ExceptionDetails exceptionDetails;

    public ResultDetails() {
        super();
    }

    public ResultDetails(String suiteName, String startTime, String endTime, String host, String status,
                         TestCaseDetails testCaseDetails, List<String> logs, ExceptionDetails exceptionDetails){
        super();
        this.suiteName = suiteName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.host = host;
        this.status = status;
        this.testCaseDetails = testCaseDetails;
        this.logs = logs;
        this.exceptionDetails = exceptionDetails;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TestCaseDetails getTestCaseDetails() {
        return testCaseDetails;
    }

    public void setTestCaseDetails(TestCaseDetails testCaseDetails) {
        this.testCaseDetails = testCaseDetails;
    }

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public ExceptionDetails getExceptionDetails() {
        return exceptionDetails;
    }

    public void setExceptionDetails(ExceptionDetails exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }
}

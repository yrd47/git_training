package testnglistener.model;

import java.util.List;

/**
 * Created by yrd on 2017/5/24.
 */
public class ExceptionDetails {

    private String name;
    private String message;
    private List<StackTrace> stackTraces;
    private List<Cause> causes;

    public ExceptionDetails() {
        super();
    }

    public ExceptionDetails(String name, String message, List<StackTrace> stackTraces, List<Cause> causes){
        super();
        this.name = name;
        this.message = message;
        this.stackTraces = stackTraces;
        this.causes = causes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StackTrace> getStackTraces() {
        return stackTraces;
    }

    public void setStackTraces(List<StackTrace> stackTraces) {
        this.stackTraces = stackTraces;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }
}

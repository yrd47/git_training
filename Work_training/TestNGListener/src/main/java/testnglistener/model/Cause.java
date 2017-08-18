package testnglistener.model;

import java.util.List;

/**
 * Created by yrd on 2017/5/24.
 *
 */
public class Cause {

    private String name;
    private String message;
    private List<StackTrace> stackTraces;

    public Cause() {
        super();
    }

    public Cause(String name, String message, List<StackTrace> stackTraces) {
        super();
        this.name = name;
        this.message = message;
        this.stackTraces = stackTraces;
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
}

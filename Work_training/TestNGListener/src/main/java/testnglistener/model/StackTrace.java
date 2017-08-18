package testnglistener.model;

/**
 * Created by yrd on 2017/5/24.
 */
public class StackTrace {

    private String declaringClass;
    private String methodName;
    private String fileName;
    private String lineNumber;

    public StackTrace() {
        super();
    }

    public StackTrace(String declaringClass, String methodName, String fileName, String lineNumber) {
        super();
        this.declaringClass = declaringClass;
        this.methodName = methodName;
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    public String getDeclaringClass() {
        return declaringClass;
    }

    public void setDeclaringClass(String declaringClass) {
        this.declaringClass = declaringClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }
}

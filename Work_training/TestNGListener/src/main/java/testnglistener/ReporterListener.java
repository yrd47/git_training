package testnglistener;

import com.google.gson.Gson;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import testnglistener.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yrd on 2017/5/24.
 *log需要用户在写case时通过Reporter.log写入一些log
 *
 */
public class ReporterListener implements IReporter{

    public static final String destDirName = "output";
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        List<ResultDetails> resultDetailsList = new ArrayList<ResultDetails>();

        for (ISuite suite: suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResultMap = suite.getResults();
            for (ISuiteResult suiteResult : suiteResultMap.values()){
                ITestContext testContext = suiteResult.getTestContext();
                IResultMap passedTests = testContext.getPassedTests();
                IResultMap failedTests = testContext.getFailedTests();
                IResultMap skippedTests = testContext.getSkippedTests();
                Set<ITestResult> passedTestsResultSet = passedTests.getAllResults();
                for (ITestResult passedTestResult: passedTestsResultSet) {
                    ResultDetails resultDetails = this.wrapResultData(suiteName,passedTestResult);
                    resultDetailsList.add(resultDetails);
                    System.out.println(this.toJson(resultDetails));
                }
                Set<ITestResult> failedTestsResultSet = failedTests.getAllResults();
                for (ITestResult failedTestResult: failedTestsResultSet) {
                    ResultDetails resultDetails = this.wrapResultData(suiteName,failedTestResult);
                    resultDetailsList.add(resultDetails);
                    System.out.println(this.toJson(resultDetails));
                }
                Set<ITestResult> skippedTestResultSet = skippedTests.getAllResults();
                for (ITestResult skippedTestResult: skippedTestResultSet) {
                    ResultDetails resultDetails = this.wrapResultData(suiteName,skippedTestResult);
                    resultDetailsList.add(resultDetails);
                    System.out.println(this.toJson(resultDetails));
                }
            }
        }
        this.requestAPI(resultDetailsList);
        try {
            this.transferResource("dist",destDirName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean requestAPI(List<ResultDetails> resultDetailesList){
        boolean response = true;
        String url = "";
        this.outputResult(new Gson().toJson(resultDetailesList),"dist/assets/data.json");
//        PostResult postResult = new PostResult();
//        try {
//            response = postResult.post(url,stringBuffer.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (response == true){
//            return true;
//        }else {
//            return false;
//        }
        return true;
    }

    private void transferResource(String srcDir, String destDir) throws IOException {
        File directory = new File(destDir);
        if (!directory.exists()){
            System.out.println("目录不存在，创建目录：" + directory);
            if (directory.mkdirs()){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println("目录已存在");
        }
        File src = new File(srcDir);
        this.copyFolder(src,directory);
        System.out.println("复制成功");
    }

    private ResultDetails wrapResultData(String suiteName, ITestResult testResult){
        ResultDetails resultDetails = new ResultDetails();
        TestCaseDetails testCaseDeatils = new TestCaseDetails();
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        List<Cause> causeList = new ArrayList<Cause>();

        resultDetails.setSuiteName(suiteName);
        resultDetails.setStartTime(String.valueOf(testResult.getStartMillis()));
        resultDetails.setEndTime(String.valueOf(testResult.getEndMillis()));
        //getHost(): The host where this suite was run, or null if it was run locally
        resultDetails.setHost(testResult.getHost());
        resultDetails.setStatus(this.getStatus(testResult.getStatus()));
        //jiraId如何获得？
        testCaseDeatils.setJiraId(testResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName());
        testCaseDeatils.setTcClass(testResult.getTestClass().getRealClass().getName());
        testCaseDeatils.setTcMethod(testResult.getMethod().getMethodName());
        List<String> arguments = new ArrayList<String>();
        Object para[] = testResult.getParameters();
        for (int i=0;(para != null ) && (i<para.length) ;i++){
            arguments.add(String.valueOf(para[i]));
        }
        testCaseDeatils.setArguments(arguments);
        resultDetails.setTestCaseDetails(testCaseDeatils);
        List<String> logList = Reporter.getOutput(testResult);
        resultDetails.setLogs(logList);
        Throwable exceptionThrowable = testResult.getThrowable();
        if (! (exceptionThrowable == null)){
            exceptionDetails.setName(exceptionThrowable.toString().split(":")[0]);
            exceptionDetails.setMessage(exceptionThrowable.getMessage());
            List<StackTrace> stackTraceList = this.getStackTraceList(exceptionThrowable);
            exceptionDetails.setStackTraces(stackTraceList);
            //no cause
            Throwable causeThrowable = exceptionThrowable.getCause();
            if(!(causeThrowable == null)){
                Cause cause = new Cause();
                cause.setName(causeThrowable.toString());
                cause.setMessage(causeThrowable.getMessage());
                List<StackTrace> causeStackTraceList = this.getStackTraceList(causeThrowable);
                cause.setStackTraces(causeStackTraceList);
                causeList.add(cause);
                exceptionDetails.setCauses(causeList);
            }
            resultDetails.setExceptionDetails(exceptionDetails);
        }
        return resultDetails;
    }

    private List<StackTrace> getStackTraceList(Throwable throwable){
        List<StackTrace> stackTraceList = new ArrayList<StackTrace>();
        StackTraceElement stackTraceElement[] = throwable.getStackTrace();
        for(int i=0 ; i < stackTraceElement.length ; i++){
            StackTrace stackTrace = new StackTrace();
            stackTrace.setDeclaringClass(stackTraceElement[i].getClassName());
            stackTrace.setMethodName(stackTraceElement[i].getMethodName());
            stackTrace.setFileName(stackTraceElement[i].getFileName());
            stackTrace.setLineNumber(String.valueOf(stackTraceElement[i].getLineNumber()));
            stackTraceList.add(stackTrace);
        }
        return stackTraceList;
    }

    private String toJson(ResultDetails resultDetails){
        Gson gson = new Gson();
        String result = gson.toJson(resultDetails);
        return result;
    }

    private void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()){
            if(!dest.exists()){
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files){
                File srcFile = new File(src,file);
                File destFile = new File(dest,file);
                copyFolder(srcFile,destFile);
            }
        }else {
            InputStream inStream = new FileInputStream(src);
            OutputStream outStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer,0,length);
            }
            inStream.close();
            outStream.close();
        }
    }

    private String getStatus(int status){
        String statusString = null;
        switch (status){
            case 1:
                statusString = "SUCCESS";
                break;
            case 2:
                statusString = "FAILURE";
                break;
            case 3:
                statusString = "SKIP";
                break;
            default:
                break;
        }
        return  statusString;
    }

    private void outputResult(String result,String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
            bufferedWriter.write(result);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
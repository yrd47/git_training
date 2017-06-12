package testng.IReporter;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yrd on 2017/5/23.
 * IReporter is the listener you need to implement if you want to generate a report after all the suites are run
 */
public class ReporterListener implements IReporter{

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        List<ITestResult> list = new ArrayList<ITestResult>();
        for(ISuite suite : suites) {
            Map<String, ISuiteResult> suiteResultMap = suite.getResults();
            for (ISuiteResult suiteResult : suiteResultMap.values()){
                ITestContext testContext = suiteResult.getTestContext();
                IResultMap passedTests = testContext.getPassedTests();
                IResultMap failedTests = testContext.getFailedTests();
                IResultMap skippedTests = testContext.getSkippedTests();
                IResultMap failedConfig = testContext.getFailedConfigurations();
                list.addAll(this.listTestResult(passedTests));
                list.addAll(this.listTestResult(failedTests));
                list.addAll(this.listTestResult(skippedTests));
                list.addAll(this.listTestResult(failedConfig));
            }
        }
        this.sort(list);
        this.outputResult(list,outputDirectory+"/test.txt");
    }

    private ArrayList<ITestResult> listTestResult(IResultMap resultMap){
        Set<ITestResult> results = resultMap.getAllResults();
        return  new ArrayList<ITestResult>(results);
    }

    private void sort(List<ITestResult> list){
        Collections.sort(list, new Comparator<ITestResult>() {
            @Override
            public int compare(ITestResult o1, ITestResult o2) {
                if (o1.getStartMillis() > o2.getStartMillis()) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
    }

    private void outputResult(List<ITestResult> list, String path){
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter(new File(path)));
            StringBuffer stringBuffer = new StringBuffer();
            for (ITestResult result : list) {
                if (stringBuffer.length() != 0)
                    stringBuffer.append("\r\n");
                stringBuffer.append(result.getTestClass().getRealClass().getName())
                        .append(" ")
                        .append(result.getMethod().getMethodName())
                        .append(" ")
                        .append(result.getStartMillis())
                        .append(" ")
                        .append(result.getEndMillis())
                        .append(" ")
                        .append(this.getStatus(result.getStatus()));
            }
            output.write(stringBuffer.toString());
            output.flush();
            output.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getStatus(int status) {
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
        return statusString;
    }

    private String formatDate(long date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}

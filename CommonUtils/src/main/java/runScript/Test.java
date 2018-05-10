package runScript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String shpath = "./test.sh";
		String pypath = "python test.py";
		Process process = Runtime.getRuntime().exec(pypath);
		process.waitFor();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line).append("\n");
		}
		String result = stringBuffer.toString();
		System.out.println(result);
	}

}

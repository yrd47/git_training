package jsontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JsonTest {
	
	public static void main(String[] args) throws IOException{
		String result = "";
		URL url = new URL("http://10.101.7.54:24680/drc");
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
		String line;
		while((line = bufferedReader.readLine())!=null){
			result += line;
		}
		bufferedReader.close();
		System.out.println(result);
	}
}

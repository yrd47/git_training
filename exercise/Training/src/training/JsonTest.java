package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {
	
	public static void main(String[] args) throws IOException{
		String longitude = "";
		String latitude = "";
		Map<String, String> map = new HashMap<>();
		String result = "";
		URL url = new URL("http://restapi.amap.com/v3/geocode/regeo?key=1e1245616fc717e3ce78e35397c616dc&location="+longitude+","+latitude);
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
		String line;
		while((line = bufferedReader.readLine())!=null){
			result += line;
		}
		bufferedReader.close();
		
		
	}

}

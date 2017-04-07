package training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class urlTest {
	
	public static void main(String[] args) throws IOException{
		Map<String, String> map = new HashMap<>();
		int i=0;
		try{
			StringBuffer stringBuffer= new StringBuffer();
			FileReader fileReader = new FileReader("/Users/yrd/Downloads/loc_province.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string = null;
			while((string=bufferedReader.readLine())!=null){
				String[] list = string.split(",");
				map=getLoc(String.valueOf(list[0]), String.valueOf(list[1]));
				stringBuffer.append(list[0]+","+list[1]+":"+map.get("country")+","+map.get("province")+"\n");
				i++;
			}
			bufferedReader.close();
			fileReader.close();
			System.out.println(i);
			System.out.println(stringBuffer.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		map=getLoc(String.valueOf(0), String.valueOf(0));
		System.out.println(map.get("country"));
	}
	
	public static Map<String, String> getLoc(String longitude,String latitude) throws IOException{
		Map<String, String> map = new HashMap<>();
		String result="";
		URL url = new URL("http://restapi.amap.com/v3/geocode/regeo?key=1e1245616fc717e3ce78e35397c616dc&location="+longitude+","+latitude);
		URLConnection connection = url.openConnection();
		connection.connect();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
		String line;
		while((line = bufferedReader.readLine())!=null){
			result += line;
		}
		bufferedReader.close();
		System.out.println(result);		
		
		JSONObject jsonObject = JSONObject.parseObject(result);
		String regeocode = jsonObject.getString("regeocode");
		JSONObject addressComponentObject = JSONObject.parseObject(regeocode);
		String addressComponent = addressComponentObject.getString("addressComponent");
		JSONObject resultObject = JSONObject.parseObject(addressComponent);
		String country = resultObject.getString("country");
		System.out.println(country);
		String province = resultObject.getString("province");
		System.out.println(province);
		map.put("country", country);
		map.put("province", province);
		return map;
	}
	
	public void test(){
		Map<String, String> map = new HashMap<>();
		int i=0;
		try{
			StringBuffer stringBuffer= new StringBuffer();
			FileReader fileReader = new FileReader("/Users/yrd/Downloads/loc_province.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String string = null;
			while((string=bufferedReader.readLine())!=null){
				String[] list = string.split(",");
				map=getLoc(String.valueOf(list[0]), String.valueOf(list[1]));
				stringBuffer.append(list[0]+","+list[1]+":"+map.get("country")+","+map.get("province")+"\n");
				i++;
			}
			bufferedReader.close();
			fileReader.close();
			System.out.println(i);
			System.out.println(stringBuffer.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JavaFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			StringBuffer stringBuffer = new StringBuffer("");
			
			FileReader reader = new FileReader("/Users/yrd/Downloads/test.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String string = null;
			
			while((string = bufferedReader.readLine()) != null){
				stringBuffer.append(string+"\n");
				System.out.println(string);
				String[] list = null;
				list = string.split(",");
				System.out.println(list[0]);
				System.out.println(list[4]);
			}
			
			bufferedReader.close();
			reader.close();
			
			//write string to file
//			FileWriter writer = new FileWriter("/Users/yrd/Downloads/test.txt");
//			BufferedWriter bufferedWriter = new BufferedWriter(writer);
//			bufferedWriter.write(stringBuffer.toString());			
//			bufferedWriter.close();
//			writer.close();
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

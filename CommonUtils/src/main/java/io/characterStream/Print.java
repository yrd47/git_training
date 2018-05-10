package io.characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print();
	}
	
	public static void print() {
		char[] buffer = new char[512];
		int numberRead = 0;
		try(FileReader fileReader = new FileReader("test.sh");
				FileWriter fileWriter = new FileWriter("fileWriter.txt")) {
			while ((numberRead = fileReader.read(buffer)) != -1) {
				fileWriter.write(buffer, 0, numberRead);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void concennateFile(String... fileName) throws IOException{
		String str;  
	     //构建对该文件您的输入流  
	     BufferedWriter writer=new BufferedWriter(new FileWriter("D:/David/Java/java 高级进阶/files/copy2.txt"));  
	     for(String name: fileName){  
	        BufferedReader reader=new BufferedReader(new FileReader(name)); 
	        while ((str=reader.readLine())!=null) {  
	           writer.write(str);  
	           writer.newLine();  
	        }  
	     }  
	}

}

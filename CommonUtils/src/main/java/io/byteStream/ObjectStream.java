package io.byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeObject();
	}

	public static void writeObject() {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.txt"));
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.txt"))) {
			objectOutputStream.writeObject(new Student("yy", 11));
			objectOutputStream.writeObject(new Student("rr", 12));
			objectOutputStream.writeObject(new Student("dd", 13));
			for (int i = 0; i < 3; i++) {
				System.out.println(objectInputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	class Student implements Serializable {
		private String name;  
		private int age;  
	    
	   public Student(String name, int age) {  
	      super();  
	      this.name = name;  
	      this.age = age;  
	   }  
	   
	   @Override  
	   public String toString() {  
	      return "Student [name=" + name + ", age=" + age + "]";  
	   }  
	}

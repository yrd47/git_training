package io.file;

import java.io.File;
import java.util.List;

public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list();
	}
	
	public static void createFile() {
		File file = new File("/Users/yrd/Learning/java_learn/topics/IO/create.txt");
		try {
			//当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件
			file.createNewFile();
			System.out.println("该分区大小" + file.getTotalSpace()/(1024 * 1024 * 1024) + "G");
			//创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
			file.mkdirs();
			//返回由此抽象路径名表示的文件或目录的名称
			System.out.println("文件名：" + file.getName());
			//返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null
			System.out.println("文件父目录字符串：" + file.getParent());
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void list() {
		File file = new File("/data");
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
	}
}

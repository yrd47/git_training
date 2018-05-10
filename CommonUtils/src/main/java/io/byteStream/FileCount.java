package io.byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.IIOException;

public class FileCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileCount();
		fileCopy();
	}
	
	public static void fileCount() {
		int count = 0;	//统计文件字节长度
		try(InputStream inputStream = new FileInputStream(new File("test.sh"))) {
			//read()方法每次读取一个字节，若文件很大将要读取很多次，所以引出缓冲区概念。
			//Java I/O默认是不缓冲流的，所谓“缓冲”就是先把从流中得到的一块字节序列暂存在一个被称为buffer的内部字节数组里，然后你可以一下子取到这一整块的字节数据
			//有两个特殊的输入流实现了缓冲功能，一个是我们常用的BufferedInputStream
			//可以将streamReader.read()改成streamReader.read(byte[]b)此方法读取的字节数目等于字节数组的长度，读取的数据被存储在字节数组中，返回读取的字节数,-1表示到末尾
			while (inputStream.read() != -1) {
				count++;
			}
			System.out.println("---长度是： "+count+" 字节");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void  fileCopy() {
		byte[] buffer = new byte[512];	//一次取出的字节数大小,缓冲区大小512字节
		int numberRead = 0;
		try(FileInputStream fileInputStream = new FileInputStream("test.sh");
				FileOutputStream fileOutputStream = new FileOutputStream("copy.sh")) {
			//numberRead的目的在于防止最后一次读取的字节小于buffer长度
			while ((numberRead = fileInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, numberRead);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

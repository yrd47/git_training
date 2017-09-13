package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileTest {
	
	public static void main(String[] args) {
		File source = new File("/Users/yrd/Desktop/node/apache-jmeter-2.13.tar.gz");
		File dest = new File("/Users/yrd/Desktop/node/1");
		FileCopy.fileCopyWithTry(source, dest);
	}

}

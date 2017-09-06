package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileCopy {
	
	public static void fileChannelCopy(File source, File dest) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		FileChannel fileChannelIn = null;
		FileChannel fileChannelOut = null;
		try {
			fileInputStream = new FileInputStream(source);
			fileOutputStream = new FileOutputStream(dest);
			fileChannelIn = fileInputStream.getChannel();
			fileChannelOut = fileOutputStream.getChannel();
			fileChannelIn.transferTo(0, fileChannelIn.size(), fileChannelOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				fileChannelIn.close();
				fileOutputStream.close();
				fileChannelOut.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		try {
			source.deleteOnExit();
			System.out.println("delete " + source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

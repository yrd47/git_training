package recursive;

import java.io.File;

public class ListDIr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strPath = "/Users/yrd/Desktop/w3school";
		try {
			getDir(strPath);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static void getDir(String strPath) throws Exception {
		try {
			File file = new File(strPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println(file2.getPath());
						getDir(file2.getPath());
					}
					if (file2.isFile()) {
						System.out.println(file2.getPath());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e);
		}
	}

}

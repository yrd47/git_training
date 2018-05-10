package system;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(File.pathSeparator);
//		System.getProperties().list(System.out);
	}

}

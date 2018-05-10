package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HelloClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("localhost", 9999);
		Scanner scanner = new Scanner(client.getInputStream());
		scanner.useDelimiter("\n");
		if (scanner.hasNext()) {
			System.out.println("[回应数据]: " + scanner.next());
		}
		scanner.close();
		client.close();
	}

}

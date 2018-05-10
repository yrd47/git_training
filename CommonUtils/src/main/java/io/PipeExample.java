package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

	public static void main(String[] args) throws IOException {
		final PipedOutputStream pipedOutputStream = new PipedOutputStream();
		final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pipedOutputStream.write("Hello world, pipe!".getBytes());
				} catch (IOException e) {
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = pipedInputStream.read();
					while(data != -1) {
						System.out.println((char)data);
						data = pipedInputStream.read();
					}
				} catch (IOException e) {
				} finally {
					try {
						pipedOutputStream.close();
						pipedInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}

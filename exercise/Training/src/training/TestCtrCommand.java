package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class TestCtrCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostname = "10.101.7.54";
		String username = "www-data";
		String password = "1qaz@WSX" ;
		
		Connection connection = new Connection(hostname);
		Session ssh = null;
		
		try{
			connection.connect();
			boolean isconn = connection.authenticateWithPassword(username, password);
			if (!isconn){
				System.out.println("用户名或密码不正确");
			}
			else {
				System.out.println("连接成功");
				//将本地文件传到远程主机的指定目录下
				SCPClient clt = connection.createSCPClient();
//				clt.put("/Users/yrd/Desktop/gzs-test.jar", "/home/www-data");
				
				//执行命令
				ssh = connection.openSession();
				ssh.execCommand("ls -ltr");
				//只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常.
				//使用多个命令用分号隔开
				//ssh.execCommand("cd /root; sh hello.sh");
				
				//将Terminal屏幕上的文字全部打印出来
				InputStream inputStream = new StreamGobbler(ssh.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(inputStream));
				while(true){
					String line = brs.readLine();
					if (line == null){
						break;
					}
					System.out.println(line);
				}
			}
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(ssh!=null){
				ssh.close();
			}
			if (connection!=null){
				connection.close();
			}
		}
	}

}

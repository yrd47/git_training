package callback;

/*
 * http://www.cnblogs.com/xrq730/p/6424471.html
 * 回调的核心就是回调方将本身即this传递给调用方
 */
public class CallbackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Yrd();
		Teacher teacher = new Teacher(student);
		
		teacher.askQuestion();
	}

}

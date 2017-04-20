package callback;

public class Teacher implements Callback{
	
	private Student student;
	
	public Teacher(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
	}
	
	public void askQuestion(){
		student.resolveQuestion(this);
	}
	
	@Override
	public void tellAnswer(int answer){
		System.out.println("知道了，答案是：" + answer );
	}

}

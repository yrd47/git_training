package callback;

public class Yrd implements Student{
	
	@Override
	public void resolveQuestion(Callback callback){
		try{
			Thread.sleep(3000L);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		callback.tellAnswer(3);
	}

}

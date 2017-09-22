package string;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "Hello";
		String bString = "Hello";
		System.out.println(aString == bString);
		
		String cString = new String("Hello");
		System.out.println(cString == aString);
		
		String dString = new String("Hello").intern();
		System.out.println(dString == aString);
		System.out.println(dString == cString);
		
		String eString = new String("Hello");
		System.out.println(eString == dString);
	}

}

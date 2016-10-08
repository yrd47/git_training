package training;

public class training {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "a";
		String str2 = "b";
		String str3 = "ab";
		String str4 = str1 + str2;
		String str5 = new String("ab");
		System.out.println(str5.equals(str3));
		System.out.println(str5==str3);
		System.out.println(str3==str4);
		System.out.println(str3==str4);
		System.out.println(str4);
		System.out.println(str5.intern()==str3);
		System.out.println(str5.intern()==str4);
	}

}

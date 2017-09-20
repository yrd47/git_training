package list;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceList sequenceList = new SequenceList();
		LinkList linkList = new LinkList();
		System.out.println(sequenceList.size());
		try {
			sequenceList.insert(0, 1);
			System.out.println(sequenceList.size());
			sequenceList.insert(1, 2);
			System.out.println(sequenceList.size());
			System.out.println(linkList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

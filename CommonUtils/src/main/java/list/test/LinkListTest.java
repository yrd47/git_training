package list.test;

public class LinkListTest {
	
	public static void main(String[] args) throws Exception {
		LinkList linkList = new LinkList();
		for (int i = 0; i < 10; i++) {
			int tmp = ((int) (Math.random() * 100)) % 100;
			linkList.insert(i, tmp);
			System.out.print(tmp + " ");
		}
		System.out.print("\n"+ linkList.size);
		linkList.delete(4);
		System.out.println(linkList.size);
		for (int i = 0; i < linkList.size; i++) {
			System.out.print(linkList.get(i) + " ");
		}
	}

}

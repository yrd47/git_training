package list.test;

class TestNode {
	private String data;
	private TestNode next;
	
	public TestNode(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TestNode getNext() {
		return next;
	}

	public void setNext(TestNode next) {
		this.next = next;
	}
	
	public void addNode(TestNode newNode) {
		if (this.next == null) {
			this.next = newNode;
		} else {
			this.next.addNode(newNode);
		}
	}
	
	public void pringNode() {
		System.out.println(this.data);
		if (this.next != null) {
			this.next.pringNode();
		}
	}
}

class Link {
	private TestNode root;
	
	public void add(String data) {
		TestNode node = new TestNode(data);
		if (root == null) {
			this.root = node;
		} else {
			this.root.addNode(node);
		}
	}
	
	public void print() {
		if (this.root != null) {
			this.root.pringNode();
		}
	}
}

public class FirstCodeList {
	public static void  main(String[] args) {
		Link link = new Link();
		link.add("yuan");
		link.add("ri");
		link.add("dan");
		link.print();
	}
}

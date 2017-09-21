package list.test;

public class Node {
	
	//数据域
	Object element;
	//指针域
	Node next;
	
	//头结点的构造方法
	public Node(Node nextval) {
		this.next = nextval;
	}
	
	//非头结点的构造方法
	public Node(Object object, Node nextval) {
		this.element = nextval;
		this.next = nextval;
	}
	
	//获得当前结点的指针域
	public Node getNext() {
		return this.next;
	}
	
	public Object getElement() {
		return this.element;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setElement(Object object) {
		this.element = object;
	}
	
	public String toString() {
		return this.element.toString();
	}
}

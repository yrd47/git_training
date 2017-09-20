package list;

public class LinkList implements List {
	
	Node head;	//头指针
	Node current;	//当前结点对象
	int size;		//结点个数
	
	//初始化一个空链表
	public LinkList() {
		// TODO Auto-generated constructor stub
		//初始化头结点，让头指针指向头结点，并且让当前对象等于头结点
		this.head = current = new Node(null);
		this.size = 0;
	}
	
	//定位函数，让当前结点对象定位到要操作的结点
	public void index(int index) throws Exception {
		if (index < -1 || index > size - 1) {
			throw new Exception("");
		}
		//说明在头结点之后操作；第一个数据元素结点的下标是0，头结点的下标为-1
		if (index == -1) {
			return;
		}
		current = head.next;
		int i = 0;
		while (current != null && i < index) {
			current = current.next;
			i++;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void insert(int index, Object object) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		index(index - 1);	//定位到要操作结点的前一个结点对象
		current.setNext(new Node(object, current.next));
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("链表为空");
		}
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		index(index - 1);
		current.setNext(current.next.next);
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index < -1 || index > size - 1) {
			throw new Exception("参数错误");
		}
		index(index);
		return current.getElement();
	}

}

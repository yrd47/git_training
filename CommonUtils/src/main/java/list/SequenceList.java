package list;

public class SequenceList implements List {
	
	final int defaultSize = 10;
	int maxSize;
	int size;
	Object[] listArray;

	public SequenceList() {
		// TODO Auto-generated constructor stub
		init(defaultSize);
	}
	
	public SequenceList(int size) {
		init(size);
	}
	
	private void init(int size) {
		maxSize = size;
		this.size = 0;
		listArray = new Object[maxSize];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void insert(int index, Object object) throws Exception {
		// TODO Auto-generated method stub
		if (size == maxSize) {
			throw new Exception("顺序表已满");
		}
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		for (int i = size - 1; i >= index; i--) {
			listArray[i + 1] = listArray[i];
		}
		listArray[index] = object;
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("顺序表为空");
		}
		if (index < 0 || index > size -1 ) {
			throw new Exception("参数错误");
		}
		for (int i = index; i < size - 1; i++) {
			listArray[i] = listArray[i + 1];
		}
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new Exception("参数错误");
		}
		return listArray[index];
	}

}

package ds.array_list;

// Time: 2:00

public class A_ArrayList_25 {

	private final static int DEFAULT_CAPACITY = 100;
	private final static int EXPAND_FACTOR = 2;
	
	private int[] values;
	private int capacity;
	private int size;
	
	public A_ArrayList_25(int capacity) {
		this.capacity = capacity;
		values = new int[capacity];
		size = 0;
				
	}
	
	public A_ArrayList_25() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public void add(int v) {
		ensureCapacity();
		values[size ] = v;
		size ++;
	}
	
	public int get(int index) {
		if(index < 0 || index > size) throw new IndexOutOfBoundsException("Index is out of bounds:" + index);
		return values[index];
	}
	
	public void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
	
}

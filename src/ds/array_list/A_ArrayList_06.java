package src.ds.array_list;

// 3:10

public class A_ArrayList_06 {

	public final static int DEFAULT_CAPACITY = 100;
	public final static int EXPAND_FACTOR = 2;
	
	private int[] values;
	private int capacity;
	private int size;
	
	public A_ArrayList_06(int capacity) {
		this.capacity = capacity;
		this.values = new int[capacity];
		this.size = 0;
	}
	
	public A_ArrayList_06() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public void add(int v) {
		ensureCapacity();
		values[size] = v;
		size ++;
	}
	
	public int get(int index) {
		if(index > size | index < 0) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
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

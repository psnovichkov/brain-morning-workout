package ds.array_list;

public class A_ArrayList_05 {

	public final static int DEFAULT_CAPACITY = 100;
	public final static int EXPAND_FACTOR = 2;
	
	private int[] values;
	private int capacity;
	private int size;
	
	public A_ArrayList_05(int capacity) {
		this.capacity = capacity;
		this.values = new int[capacity];
		this.size = 0;
	}
	
	public A_ArrayList_05() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return this.size;
	}
	
	public void add(int v) {
		ensureCapcity();
		values[size] = v;
		size ++;
	}
	
	public int get(int index) {
		if(index > size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		return values[index];
	} 
	
	public void ensureCapcity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
}

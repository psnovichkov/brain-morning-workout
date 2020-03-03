package src.ds.array_list;

/**
 * start  5:07
 * end    5:11:24
 * @author psnovichkov
 *
 */
public class P_ArrayList_02 {
	
	private static final int DEFAULT_CAPACITY = 100;
	private static final int EXPAND_FACTOR = 2;
	
	private int capacity;
	private int size;
	private int[] values;
	
	public P_ArrayList_02(){
		this(DEFAULT_CAPACITY);
	}
	
	public P_ArrayList_02(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.values = new int[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public int get(int index) {
		if(index >= size) throw new IndexOutOfBoundsException();
		return values[index];
	}
	
	public void add(int data) {
		ensureCapacity();
		values[size++] = data;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
}

package src.ds.array_list;

/**
 * 
 * start 2:52
 * end   2:56:29
 * 
 * @author psnovichkov
 *
 */
public class P_ArrayList_03 {

	private static final int DEFAULT_CAPACITY = 100;
	private static final int EXPAND_FACTOR = 2;
	
	private int capacity;
	private int[] values;
	private int size;
	
	public P_ArrayList_03() {
		this(DEFAULT_CAPACITY);
	}
	
	public P_ArrayList_03(int capacity) {
		this.capacity = capacity;
		this.values = new int[capacity];
		this.size = 0;
	}
	
	public void add(int value) {
		ensureCapacity();
		values[size++] = value;
	}
	
	public int get(int index) {
		if(index >= size) throw new ArrayIndexOutOfBoundsException();
		return values[index];
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			int[] temp = new int[capacity];
			System.arraycopy(values, 0, temp, 0, size);
			values = temp;
		}
	}
}	

package ds.array_list;

/**
 * 3:45
 * @author psnovichkov
 *
 */
public class P_ArrayList_04 {

	private final static int DEFAULT_CAPACITY = 100;
	private final static int EXPAND_FACTOR = 2;
	
	private int[] values;
	private int capacity;
	private int size;
	
	public P_ArrayList_04(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		values = new int[capacity];
	}
	
	public P_ArrayList_04() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size () {
		return size;
	}
	
	public int get(int index) {
		if(index >= size) throw new IndexOutOfBoundsException();
		
		return values[index];
	}
	
	public void add(int value) {
		ensureCapcity();
		values[size++] = value;
	}

	private void ensureCapcity() {
		if(size >= capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
	
}

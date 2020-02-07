package ds;

/**
 * Start 8:03
 * End   8:07:26
 * 
 * @author psnovichkov
 *
 */
public class P_ArrayList_01 {

	final static int DEFAULT_CAPACITY = 100;
	final static int EXAPND_FACTOR = 2;
	
	private int capacity;
	private int size;
	private int[] values;
	
	public P_ArrayList_01(){
		this(DEFAULT_CAPACITY);
	}
	
	public P_ArrayList_01(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.values = new int[capacity];
	}
	
	public int get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return values[index];
	}
	
	public void add(int data) {
		ensureCapacity();
		values[size++] = data; 
	}

	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXAPND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
}

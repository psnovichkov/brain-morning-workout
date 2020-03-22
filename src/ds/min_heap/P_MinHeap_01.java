package ds.min_heap;

/**
 * Start  8:13
 * End    8:23:38
 * @author psnovichkov
 *
 */
public class P_MinHeap_01 {
	private static final int DEFAULT_CAPACITY = 100;
	private static final int EXPAND_FACTOR = 2;
	private static final int ROOT_INDEX = 1;
	
	
	private int[] values;
	private int size;
	private int capacity;
	
	public P_MinHeap_01() {
		this(DEFAULT_CAPACITY);
	}

	public P_MinHeap_01(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.values = new int[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Empty");
		return values[ROOT_INDEX];
	}
	
	public int poll() {
		int val = values[ROOT_INDEX];
		values[ROOT_INDEX] = values[lastIndex()];
		size--;
		
		heapifyDown();
		return val;
	}
	
	public void add(int data) {
		enszureCapactiy();
		size++;
		values[lastIndex()] = data;
		heapifyUp();
	}
	
	private void heapifyDown() {
		int pIndex = ROOT_INDEX;
		int leftIndex = pIndex * 2;
		int rightIndex = leftIndex + 1;
		
		while( validIndex(leftIndex) ) {
			int minIndex = leftIndex;
			if( validIndex(rightIndex) && values[rightIndex] < values[leftIndex] ) {
				minIndex = rightIndex;
			}
			
			if(values[pIndex] <= minIndex) break;
			swap(pIndex, minIndex);
			pIndex = minIndex;
			leftIndex = pIndex * 2;
			rightIndex = leftIndex + 1;
		}
	}
	
	private void heapifyUp() {
		int cIndex = lastIndex();
		int pIndex = cIndex / 2;
		while( validIndex(pIndex) ) {
			if(values[cIndex] <= values[pIndex]) break;
			swap(cIndex, pIndex);
			cIndex = pIndex;
			pIndex /= 2;
		}
	}
	
	
	private boolean validIndex(int index) {
		return index >= ROOT_INDEX && index <= lastIndex();
	}
	
	private int lastIndex() {
		return ROOT_INDEX + size - 1;
	}
	
	private void swap(int i, int j) {
		int tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	private void enszureCapactiy() {
		if( ROOT_INDEX + size >= capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
}

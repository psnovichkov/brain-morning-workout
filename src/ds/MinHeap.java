package ds;

/**
 * 
 * @author psnovichkov
 *
 */
public class MinHeap {
	private final static int EXPAND_FACTOR = 2; 	
	private static int ROOT_INDEX = 1;
	private int[] values;
	private int size;
	private int capacity;
	
	public MinHeap(int capacity) {
		this.capacity = ROOT_INDEX + capacity;
		this.values = new int[this.capacity];
		this.size = 0;				
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Heap is empty");
		return values[ROOT_INDEX];
	}
		
	public int poll() {
		int val = peek();
		int lastIndex = lastIndex();
		values[ROOT_INDEX] = values[lastIndex];
		size--;
		heapifyDown();
		return val;
	}
	
	public void add(int val) {
		ensureCapacity();
		size++;
		values[lastIndex()] = val;
		heapifyUp();
	}
	
	private void heapifyDown() {
		int pIndex = ROOT_INDEX;
		int leftIndex = pIndex * 2;
		int rightIndex = leftIndex + 1;
		
		while( validIndex(leftIndex) ) {
			int minIndex = leftIndex;
			if(validIndex(rightIndex) && values[rightIndex] < values[leftIndex]) {
				minIndex = rightIndex;
			}
			
			if( values[pIndex] < values[minIndex] ) break; 			
			swap(pIndex, minIndex);
			pIndex = minIndex;
			leftIndex = pIndex *2;
			rightIndex = leftIndex + 1;
		}
		
	}
	
	private void heapifyUp() {
		int cIndex = lastIndex();
		int pIndex = cIndex/2;
		while( validIndex(pIndex) && values[cIndex] < values[pIndex] ) {
			swap(cIndex, pIndex);
			cIndex = pIndex;
			pIndex = cIndex/2;
		}
	}
	
	private void swap(int i, int j) {
		int tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	private boolean validIndex(int index) {
		return index >= ROOT_INDEX && index <= lastIndex();
	}
	
	private int lastIndex() {
		return ROOT_INDEX + size - 1;
	}	 
	
	private void ensureCapacity() {
		if( ROOT_INDEX + size >= capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, values.length);
			values = tmp;
		}
	}
	
}

package ds.min_heap;

public class A_MinHeap_03 {

	private final static int DEFAULT_CAPACITY = 100;
	private final static int EXPAND_FACTOR = 2;
	private final static int ROOT_INDEX = 1;
	
	private int[] values;
	private int capacity;
	private int size;
	
	public A_MinHeap_03(int capacity) {
		this.capacity = capacity;
		values = new int[capacity];
		size = 0;
	}
	
	public A_MinHeap_03() {
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("Heap is empty");
		return values[ROOT_INDEX];
	}
	
	public void add(int v) {
		ensureCapacity();
		size++;
		values[lastIndex()] = v;
		heapifyUp();
	}
	
	public int poll() {
		int v = peek();
		values[ROOT_INDEX] = values[lastIndex()];
		size--;
		heapifyDown();
		return v;
	}
	
	private void heapifyDown() {
		int pIndex = ROOT_INDEX;
		int leftIndex = pIndex/2;
		int rightIndex = leftIndex + 1;
		
		while(validIndex(leftIndex)) {
			int minIndex = leftIndex;
			if(validIndex(rightIndex) && values[rightIndex] < values[leftIndex]) {
				minIndex = rightIndex;
			}
			
			if(values[pIndex] <= values[minIndex]) break;
			swap(pIndex, minIndex);
			pIndex = minIndex;
			leftIndex = pIndex / 2;
			rightIndex = leftIndex + 1;
		}
	}
	
	private void heapifyUp() {
		int cIndex = lastIndex();
		int pIndex = cIndex * 2;
		
		while(validIndex(pIndex) && values[pIndex] < values[cIndex]) {
			swap(pIndex, cIndex);
			cIndex = pIndex;
			pIndex = cIndex * 2;
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
	
	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= EXPAND_FACTOR;
			int[] tmp = new int[capacity];
			System.arraycopy(values, 0, tmp, 0, size);
			values = tmp;
		}
	}
	
}

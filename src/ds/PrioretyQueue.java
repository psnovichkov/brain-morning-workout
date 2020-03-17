package ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author psnovichkov
 *
 * @param <V>
 */
public class PrioretyQueue<V extends Comparable<V>>{
	private static final int ROOT_INDEX = 1;
	private static final int DEFAULT_CAPACITY = 100;
	private static final int EXPAND_FACTOR = 2;
	
	private V[] values;
	private int size;
	private int capacity;

	private Map<V, Integer> indices;
	
	public PrioretyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public PrioretyQueue(int capacity) {
		this.capacity = ROOT_INDEX + capacity;
		this.values = (V[]) new Comparable[this.capacity];
		this.size = 0;
		this.indices = new HashMap<>();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public V peek() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");
		return values[ROOT_INDEX];
	}
	
	
	public V pop() {
		V val = peek();
		values[ROOT_INDEX] = values[lastIndex()];
		size--;
		
		indices.remove(val);
		indices.put(values[ROOT_INDEX], ROOT_INDEX);
		
		heapifyDown(ROOT_INDEX);
		
		return val;
	}
		
	public void add(V item) {
		ensureCapacity();
		size++;
		
		values[lastIndex()] = item;
		indices.put(item, lastIndex());		
		
		heapifyUp(lastIndex());
	}
	
	public boolean update(V oldValue, V newValue) {
		Integer index = indices.get(oldValue);
		if(index == null) return false;
		
		values[index] = newValue;
		indices.remove(oldValue);
		indices.put(newValue, index);
		
		int cmp = newValue.compareTo(oldValue);
		if(cmp < 0) {
			heapifyUp(index);
		} else if (cmp > 0) {
			heapifyDown(index);
		}
		
		return true;
	}
	
	private void heapifyUp(int index) {
		int chIndex = index;
		int pIndex = chIndex/2;
		while( validIndex(pIndex) && compare(pIndex, chIndex) > 0 ) {
			
			swap(chIndex, pIndex);			
			chIndex = pIndex;
			pIndex /= 2;
		}
	}
	
	
	private void heapifyDown(int index) {
		int pIndex = index;
		int leftIndex = pIndex * 2;
		int rightIndex = leftIndex + 1;
		
		while(validIndex(leftIndex)) {
			int minIndex = leftIndex;
			if(validIndex(rightIndex) && compare(rightIndex, leftIndex) < 0) {
				minIndex = rightIndex;
			}
			
			if( compare(minIndex, pIndex) >= 0  ) {
				break;
			} 
			
			swap(pIndex, minIndex);
			pIndex = minIndex;
			leftIndex = pIndex *2;
			rightIndex = leftIndex + 1;
		}
		
	}
	
	private int compare(int i, int j) {
		return values[i].compareTo(values[j]);
	}
	
	private boolean validIndex(int index) {
		return index >= ROOT_INDEX && index <= lastIndex();
	}
	
	private int lastIndex() {
		return ROOT_INDEX + size - 1;
	}
	
	private void swap(int i, int j) {
		V tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
		
		indices.put(values[i], i);
		indices.put(values[j], j);
	}
	
	private void ensureCapacity() {
		if(size + ROOT_INDEX >= capacity) {
			capacity *= EXPAND_FACTOR;
			Comparable[] tmp = new Comparable[capacity];
			System.arraycopy(values, 0, tmp, 0, values.length);
			this.values = (V[]) tmp;
		}
	}	
}

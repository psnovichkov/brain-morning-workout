package ds.hash_map;

public class A_HashMap_43<K,V>{

	private final static int DEFAULT_CAPACITY = 100;
	
	static class Item<K,V>{
		K key;
		V value;
		
		Item<K,V> next;
		
		Item(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	private Item<K,V>[] buckets;
	private int capacity;
	private int size;
	
	public A_HashMap_43(int capacity) {
		this.capacity = capacity;
		buckets = new Item[capacity];
		size = 0;
	}
	
	public A_HashMap_43() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public int getIndex(K key) {
		return Math.abs(key.hashCode()%capacity);
	}
	
	public V get(K key) {
		Item<K,V> item = findItem(key);
		return item != null ? item.value : null;
	}
	
	private Item<K,V> findItem(K key){
		Item<K,V> item = buckets[getIndex(key)];
		while(item != null) {
			if(item.key.equals(key)) break;
			item = item.next;
		}
		return item;
	}
	
	public void put(K key, V value) {
		Item<K,V> item = findItem(key);
		if(item == null) {
			int index = getIndex(key);
			item = new Item<K,V>(key, value);
			
			item.next = buckets[index];
			buckets[index] = item;
			size++;
		}else {
			item.value = value;
		}
	}
	
}

package ds;

public class A_HashTable_03<K,V>{

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
	
	private Item<K,V>[] values;
	private int capacity;
	private int size;
	
	@SuppressWarnings("unchecked")
	public A_HashTable_03(int capacity) {
		this.capacity = capacity;
		values = new Item[capacity];
		size = 0;
	}
	
	public A_HashTable_03() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	
	public int getIndex(K key) {
		return key.hashCode()%capacity;
	}
	
	public V get(K key) {
		Item<K,V> item = findItem(key);
		return item != null ? item.value : null;
	}
	
	private Item<K,V> findItem(K key){
		Item<K,V> item = values[getIndex(key)];
		while(item != null) {
			if(item.key == key) break;
			item = item.next;
		}
		return item;
	}
	
	public void put(K key, V value) {
		Item<K,V> item = findItem(key);
		if(item == null) {
			int index = getIndex(key);
			item = new Item<K,V>(key, value);
			
			if(values[index] == null) {
				values[index] = item;
			}else {
				item.next = values[index];
				values[index] = item;
			}
			size++;
		}else {
			item.value = value;
		}
	}
	
}

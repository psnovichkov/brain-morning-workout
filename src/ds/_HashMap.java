package ds;

public class _HashMap<K,V> {
	public static final int DEFAULT_CAPACITY = 1000;
	
	static class Item<K,V> {
		K key;
		V value;
		Item<K,V> next;
		
		Item(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	private Item<K,V>[] items;
	private int size;
	private int capacity;
	
	
	public _HashMap() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public _HashMap(int capacity) {			
		this.capacity = capacity;
		this.items = new Item[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public void put(K key, V value) {
		Item<K,V> item = findItem(key);
		if(item == null) {
			int index = key.hashCode() % capacity;
			item = items[index];
			
			Item<K,V> newItem = new Item<>(key, value);
			if(item == null) {
				items[index] =  newItem;
			} else {
				newItem.next = items[index];
				items[index] = newItem;
			}
			size++;
		} else {
			item.value = value;
		}
	}
	
	public V get(K key){
		Item<K,V> item = findItem(key);
		return item != null ? item.value : null;
	}		
	
	private Item<K,V> findItem(K key){
		int index = key.hashCode() % capacity;
		Item<K,V> item = items[index];
		while(item != null) {
			if(item.key.equals(key)) {
				break;
			} 
			item = item.next;
		}
		return item;
	}	

}

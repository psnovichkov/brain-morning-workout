package ds.hash_map;

/**
 * Start 7:11
 * End   7:19:48
 * @author psnovichkov
 *
 */
public class P_HashMap_02<K,V> {
	private static final int DEFAULT_CAPACITY = 1000;
	
	static class Item<K,V>{
		K key;
		V value;
		Item<K,V> next;
		Item(K key, V value){
			this.key = key;
			this.value = value;			
		}
	}
	
	private Item<K,V>[] items;
	private int capacity;
	private int size;
	
	public P_HashMap_02() {
		this(DEFAULT_CAPACITY);
	}
	
	public P_HashMap_02(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.items = new Item[capacity];
	}
	
	public int size() {
		return size;
	}

	
	public void put(K key, V value) {
		Item<K,V> item = find(key);
		if(item == null) {
			item = new Item<K,V>(key, value);
			int index = keyIndex(key);
			if(items[index] == null) {
				items[index] = item;
			} else {
				item.next = items[index];
				items[index] = item;
			}
			size ++;			
		} else {
			item.value = value;
		}
	}
	
	public V get(K key) {
		Item<K,V> item = find(key);
		return item != null ? item.value : null;
	}
	
	
	private Item<K,V> find(K key){
		int index = keyIndex(key);
		Item<K,V> item = items[index];
		while(item != null) {
			if(item.key == key) break;
			item = item.next;
		}
		return item;
	}
	
	private int keyIndex(K key) {
		return key.hashCode() % capacity;
	}
	
}

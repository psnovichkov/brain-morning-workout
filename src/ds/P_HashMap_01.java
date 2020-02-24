package ds;

/**
 * Start 3:20
 * End   3:25:51
 * 
 * @author psnovichkov
 *
 * @param <K>
 * @param <V>
 */

public class P_HashMap_01<K,V> {

	private static final int DEFAULT_CAPACITY = 1000;
	
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
	private int capacity;
	private int size;
	
	public P_HashMap_01() {
		this(DEFAULT_CAPACITY);
	}
	
	public P_HashMap_01(int capacity) {
		this.capacity = capacity;
		this.items = new Item[capacity];
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	private Item<K,V> findItem(K key){
		int index = key.hashCode()%capacity;
		Item<K,V> item = items[index];
		while(item != null) {
			if(item.key.equals(key)) {
				break;
			}
			item = item.next;
		}
		
		return item;
	} 
	
	public V get(K key) {
		Item<K,V> item = findItem(key);
		return item != null ? item.value : null;
	}
	
	public void put(K key, V value) {
		Item<K,V> item = findItem(key);
		if(item == null) {
			int index = key.hashCode()%capacity;
			item = new Item<>(key, value);
			
			if(items[index] == null) {
				items[index] = item;
			} else {
				item.next = items[index];
				items[index] = item;
			}
			size++;
			
		} else {
			item.value = value;
		}

	}
}

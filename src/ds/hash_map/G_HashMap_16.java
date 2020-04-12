package ds.hash_map;

public class G_HashMap_16<K, V> {

    public static final int DEFAULT_CAPACITY = 10;

    private int capacity;
    private int size;
    private Item[] items;


    static class Item<K, V> {
        K key;
        V value;
        Item<K, V> next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    G_HashMap_16(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    G_HashMap_16() {
        this(DEFAULT_CAPACITY);
    }

    public V get(K key) {
        Item<K, V> item = findItem(key);
        return item == null ? null : item.value;
    }

    public void insert(K key, V value) {
        Item<K, V> item = findItem(key);
        if (item == null) {
            Item<K, V> newItem = new Item<>(key, value);
            int index = key.hashCode() % capacity;
            newItem.next = items[index];
            items[index] = newItem;
            size ++;
        } else {
            item.value = value;
        }
    }

    private Item<K, V> findItem(K key) {
        int index = key.hashCode() % capacity;
        Item<K, V> item = items[index];
        while (item != null) {
            if (item.key.equals(key)) break;
            item = item.next;
        }
        return item;
    }
}

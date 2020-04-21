package ds.hash_map;

public class G_HashMap_22<K, V> {

    private final static int DEFAULT_CAPACITY = 10;

    static class Item<K, V> {
        K key;
        V value;
        Item<K, V> next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Item[] items;

    G_HashMap_22(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    G_HashMap_22() {
        this(DEFAULT_CAPACITY);
    }

    public void insert(K key, V value) {
        Item<K, V> item = findItem(key);
        if (item == null) {
            item = new Item<>(key, value);
            int index = key.hashCode() % capacity;
            item.next = items[index];
            items[index] = item;
            size++;
        } else {
            item.value = value;
        }
    }

    public V get(K key) {
        Item<K, V> item = findItem(key);
        return item == null ? null : item.value;
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

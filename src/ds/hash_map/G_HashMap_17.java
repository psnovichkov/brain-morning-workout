package ds.hash_map;

public class G_HashMap_17<K, V> {

    private static final int DEFAULT_CAPACUTY = 10;

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

    G_HashMap_17(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    G_HashMap_17() {
        this(DEFAULT_CAPACUTY);
    }


    public V get(K key) {
        Item<K, V> item = findItem(key);
        return item == null ? null : item.value;
    }

    public void put(K key, V value) {
        Item<K, V> item = findItem(key);
        if (item == null) {
            int index = key.hashCode() % capacity;
            item = new Item<>(key, value);
            item.next = items[index];
            items[index] = item;
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

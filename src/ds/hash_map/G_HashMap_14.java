package ds.hash_map;

public class G_HashMap_14<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

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
    private Item[] items;

    G_HashMap_14(int capacity) {
        this.capacity = capacity;
        this.items = new Item[capacity];
    }

    G_HashMap_14() {
        this(DEFAULT_CAPACITY);
    }

    public void insert(K key, V value) {
        Item item = findItem(key);
        if (item == null) {
            Item<K, V> newItem = new Item<>(key, value);
            int index = key.hashCode() % capacity;
            item = items[index];
            if (item == null) {
                items[index] = newItem;
            } else {
                newItem.next = items[index];
                items[index] = newItem;
            }
        } else {
            item.value = value;
        }
    }

    public V get(K key) {
        Item<K, V> item = findItem(key);
        return item == null ? null : item.value;
    }

    public Item findItem(K key) {
        int index = key.hashCode() % capacity;
        Item item = items[index];
        while (item != null) {
            if (item.key.equals(key)) break;
            item = item.next;
        }
        return item;
    }
}

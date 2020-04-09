package ds.hash_map;

public class G_HashMap_15<K, V> {

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

    private int size;
    private int capacity;
    private Item[] items;

    G_HashMap_15(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    G_HashMap_15() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void insert(K key, V value) {
        Item<K, V> item = findItem(key);
        if (item == null) {
            Item<K, V> nitem = new Item<>(key, value);
            int index = key.hashCode() % capacity;
            item = items[index];
            if (item == null) {
                items[index] = nitem;
            } else {
                nitem.next = items[index];
                items[index] = nitem;
            }
            size++;
        } else {
            item.value = value;
        }
    }

    public V get(K key) {
        Item<K, V> item = findItem(key);
        return item == null ? null : item.value;
    }


    private Item findItem(K key) {
        int index = key.hashCode() % capacity;
        Item item = items[index];
        while (item != null) {
            if (item.key.equals(key)) break;
            item = item.next;
        }
        return item;
    }

}

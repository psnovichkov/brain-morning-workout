package ds.hash_map;

/**
 * time: 7:37
 * @author georgezakharov
 */

public class G_HashMap_03<K, V> {

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
    private Item<K, V>[] items;

    public G_HashMap_03(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[this.capacity];
    }

    public G_HashMap_03() {
        this(1000);
    }

    public int size() {
        return this.size;
    }


    public V get(K key) {
        Item<K, V> item = findItem(key);

        return item != null ? item.value : null;
    }

    public void put(K key, V value) {
        Item<K, V> item = findItem(key);

        if (item == null) {
            int index = key.hashCode() % capacity;
            item = items[index];

            Item<K, V> newItem = new Item<>(key, value);
            if (item == null) {
                items[index] = newItem;
            } else {
                newItem.next = items[index];
                items[index] = newItem;
            }
            size++;

        } else {
            item.value = value;
        }

    }


    private Item<K, V> findItem(K key) {
        int index = key.hashCode() % capacity;

        Item<K, V> item = items[index];
        while (item != null) {
            if (item.key == key) {
                break;
            }
            item = item.next;
        }
        return item;
    }
}

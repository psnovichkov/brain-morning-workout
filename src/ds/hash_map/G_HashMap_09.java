package ds.hash_map;

public class G_HashMap_09<K, V> {

    private static final int DEFAULT_CAPACITY = 1000;

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

    public G_HashMap_09(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    public G_HashMap_09() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void put(K key, V value) {
        Item<K, V> item = findItem(key);

        if(item == null){
            int index = key.hashCode() % capacity;
            item = new Item<>(key, value);

            item.next = items[index];
            items[index] = item;
            size ++;
        }
        else{
            item.value = value;
        }

    }

    public V get(K key){
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

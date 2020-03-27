package ds.hash_map;

public class G_HashMap_06<K, V> {


    private final int DEFAULT_CAPACITY = 1000;

    static class Item<K, V> {
        K key;
        V value;
        Item<K, V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private Item<K, V>[] items;
    private int size;
    private int capacity;


    public G_HashMap_06(int capacity) {
        this.capacity = capacity;
        this.items = new Item[capacity];
    }

    public G_HashMap_06() {
        this(10000);
    }

    public int size() {
        return this.size;
    }


    public void add(K key, V value) {
        Item<K, V> item = findItem(key);
        if(item == null){
            int index = key.hashCode() % capacity;
            item = items[index];
            // No item in items[index]
            if(item == null){
                items[index] = item;
            }
            else{
                item.next = items[index];
                items[index] = item;
            }
            // there is an item in item[index]
        }
        else{
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

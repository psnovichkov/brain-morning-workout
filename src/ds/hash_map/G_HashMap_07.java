package ds.hash_map;

public class G_HashMap_07<K, V> {

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



    G_HashMap_07(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.items = new Item[capacity];
    }

    G_HashMap_07(){
        this(1000);
    }

    public int size() {
        return size;
    }


    public void put(K key, V value) {
        Item<K, V> item = findItem(key);
        if (item == null) {
            int index = key.hashCode() % capacity;
            item = items[index];

            if (item == null) {
                items[index] = item;
            } else {
                item.next = items[index];
                items[index] = item;
            }

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
            if (item.key == key) break;

            item = item.next;
        }
        return item;
    }


}

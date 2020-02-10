package ds;


/**
 *
 *
 * time: >20
 *
 * @author georgezakharov
 */


public class G_HashMap_01<K, V> {

    private static final int DEFAULT_CAPACITY = 100;

    static class Item<K, V> {
        K key;
        V value;
        Item<K, V> next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Item<K, V>[] items;
    private int size;
    private int capacity;



    public G_HashMap_01(int capacity){
        this.capacity = capacity;
        this.items = new Item[capacity];
        this.size = 0;
    }

    public G_HashMap_01(){
        this(DEFAULT_CAPACITY);
    }


    public int size() {
        return this.size;
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
                newItem.next = item;
                items[index] = newItem;
            }
            size++;
        } else {
            item.value = value;
        }
    }


    public V get(K key) {

        Item<K, V> item = findItem(key);
        return item != null ? item.value : null;
    }

    private Item<K, V> findItem(K key) {

        int index = key.hashCode() % capacity;
        Item<K, V> item = items[index];
        while (item != null) {
            if (item.key.equals(key)) {
                break;
            }
            item = item.next;
        }
        return item;

    }
}
package ds.hash_map;


/**
 * time: 13:38
 *
 * @author georgezakharov
 */

public class G_HashMap_02<K, V> {

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


    public G_HashMap_02(int capacity) {
        this.capacity = capacity;
        this.items = new Item[capacity];
        this.size = 0;
    }

    public G_HashMap_02() {
        this(1000);
    }

    public int getSize() {
        return this.size;
    }

    public void put (K key, V value){

        Item<K, V> item = findItem(key);

        if(item == null){
            Item<K, V> newItem = new Item<>(key, value);

            int index = key.hashCode() % capacity;
            item = items[index];

            if(item == null){
                items[index] = newItem;
            }
            else{
                newItem.next = items[index];
                items[index] = newItem;
            }

            size ++;
        }
        else{
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

package ds.array_list;

public class G_ArrayList_18 {

    private final static int DEFAULT_CAPACITY = 10;
    private final static int EXPAND_FACTOR = 2;


    private int capacity;
    private int size;
    private int[] items;


    G_ArrayList_18(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.items = new int[capacity];
    }
    G_ArrayList_18(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public void insert(int val){
        ensureCapacity();
        items[size++] = val;
    }

    public int get(int index){
        if(index >= size ) throw new IndexOutOfBoundsException("Index out of bounds");
        return items[index];
    }

    private void ensureCapacity() {
        if(size >= capacity){
            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(items, 0, temp, 0, size);
            items = temp;
        }
    }
}

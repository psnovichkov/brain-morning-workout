package ds.array_list;

public class G_ArrayList_24 {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int EXPAND_FACTOR = 2;

    private int capacity;
    private int size;
    private int[] values;


    G_ArrayList_24(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.values = new int[capacity];
    }

    G_ArrayList_24() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void insert(int data) {
        ensureCapacity();
        values[size++] = data;
    }

    public int get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        return values[index];
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }
}

package ds.array_list;

public class G_ArrayList_07 {

    private final static int DEFAULT_CAPACITY = 100;
    private final static int EXPANDING_FACTOR = 2;

    private int capacity;
    private int size;
    private int[] values;

    public G_ArrayList_07(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.values = new int[capacity];
    }

    public G_ArrayList_07() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public int get(int index) {
        if (index >= capacity) throw new IndexOutOfBoundsException("index out of bounds" + index);
        return values[index];
    }

    public void add(int val) {
        ensureCapacity();
        values[size++] = val;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= EXPANDING_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }
}

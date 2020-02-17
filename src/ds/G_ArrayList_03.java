package ds;

/**
 * time:
 *
 * @author georgezakharov
 */


public class G_ArrayList_03 {

    private static final int DEFAULT_CAPACITY = 100;
    private static final int DEFAULT_EXPANDFACTOR = 2;


    private int capacity;
    private int size;
    private int[] values;


    public G_ArrayList_03(int capacity) {

        this.capacity = capacity;
        this.values = new int[capacity];
        this.size = 0;
    }

    public G_ArrayList_03() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void add(int val) {
        enshureCapacity();
        values[size] = val;
        size++;
    }

    public int get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Index out of Bounds");
        return values[index];
    }


    private void enshureCapacity() {
        if (size == capacity) {
            capacity *= DEFAULT_EXPANDFACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }


}

package src.ds.array_list;


/**
 * time: 4:06
 *
 * @author georgezakharov
 */
public class G_ArrayList_04 {

    private final static int DEFAULT_CAPACITY = 100;
    private final static int EXPAND_FACTOR = 2;


    private int capacity;
    private int size;
    private int[] values;


    public G_ArrayList_04(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.size = size;
    }

    public G_ArrayList_04() {
        this(DEFAULT_CAPACITY);
    }


    public int size() {

        return this.size;
    }

    public int get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("index out of bounds" + index);

        return values[index];
    }

    public void add(int value) {
        enshureCapacity();
        values[size] = value;
        size++;
    }


    private void enshureCapacity() {

        if (size == capacity) {
            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }


}

package ds;


/**
 * time: 8:51
 *
 * @author georgezakharov
 */

public class G_ArrayList {

    private static int DEFAULT_CAPACITY = 100;
    private static int EXPAND_FACTOR = 2;

    public int capacity;
    public int size;
    public int[] values;

    G_ArrayList(int capacity) {

        size = 0;
        this.capacity = capacity;
        values = new int[capacity];
    }


    G_ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public void add(int number) {

        enshurecapasity();
        values[size] = number;
        size++;
    }

    public int get(int index) {

        if (index >= size) throw new RuntimeException("Out of Bounds Exception");
        return values[index];
    }

    public void enshurecapasity() {

        if (size == capacity) {

            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }


    }

}

package ds;


/**
 *
 * time: 7:26
 *
 * @author georgezakharov
 */


public class G_ArrayList_02 {


    private final static int DEFAULT_CAPACITY = 100;
    private final static int EXPAND_FACTOR = 2;


    private int capacity;
    private int size;
    private int[] values;


    public G_ArrayList_02(int capacity) {

        this.capacity = capacity;
        this.values = new int[capacity];
        this.size = 0;
    }

    public G_ArrayList_02() {
        this(DEFAULT_CAPACITY);
    }


    public int getSize() {
        return size;
    }

    public void add(int data) {

        enshureCapacity();
        values[size] = data;
        size++;
    }

    public int get(int index){

        if(index >= size) throw new IndexOutOfBoundsException("out of bounds");
        return values[index];
    }


    private void enshureCapacity() {

        if (capacity == size) {
            this.capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }


}

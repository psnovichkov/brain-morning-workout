package ds;

/**
 *
 * @author psnovichkov
 *
 */

public class ArrayList {

    private final static int DEFAULT_CAPACITY = 100;
    private final static int EXPAND_FACTOR = 2;

    private int[] values;
    private int capacity;
    private int size;



    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.size = 0;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        ensureCapacity();
        values[size] = value;
        size++;
    }

    public int get(int index) {
        if(index >= size) throw new IndexOutOfBoundsException("Index is out of range: " + index);
        return values[index];
    }

    private void ensureCapacity() {
        if(size == capacity) {
            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
    }

}
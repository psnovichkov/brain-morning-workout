package ds.array_list;

public class G_ArrayList_06 {

    private final static int DEFAULT_CAPACITY = 100;
    private final static int EXPAND_FACTOR = 2;

    private int[] values;
    private int size;
    private int capacity;

    G_ArrayList_06(int capacity ){
        this.capacity = capacity;
        this.size= 0;
        this.values = new int[capacity];
    }

    G_ArrayList_06(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public void add(int v){
        ensureCapacity();
        values[size++] = v;
    }

    public int get(int index){
        if(index >= size ) throw new IndexOutOfBoundsException("Index out of bounds" + index);
        return values[index];
    }

    private void ensureCapacity(){
        if(size >= capacity){
            capacity *= EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }
    }






}

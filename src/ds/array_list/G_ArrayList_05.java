package ds.array_list;

public class G_ArrayList_05 {

    final private static int DEFAULT_EXPAND_FACTOR = 2;
    final private static int DEFAULT_CAPACTY = 100;

    private int capacity;
    private int size;
    private int[] values;


    public G_ArrayList_05 (int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.values = new int[capacity];
    }

    public G_ArrayList_05 (){
        this(DEFAULT_CAPACTY);
    }


    public int size(){
        return this.size;
    }

    public void add(int value){
        enshureCapacity();
        values[size] = value;
        size++;
    }

    public int get(int index){
        if(index >= size) throw new IndexOutOfBoundsException("Index out of bounds" + index);
        return values[index];
    }


    public void enshureCapacity(){
        if(size == capacity){
            capacity *= DEFAULT_EXPAND_FACTOR;
            int[] temp = new int[capacity];
            System.arraycopy(values, 0, temp, 0, size);
            values = temp;
        }


    }



}

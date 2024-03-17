package oy.tol.tra;

public class QueueImplementation<T> implements QueueInterface<T>{
    int size,capacity,front;
    private Object[] itemArray;
    public static int DEFAULT_CAPACITY = 10;
    public QueueImplementation(){
        this(DEFAULT_CAPACITY);
    }
    public QueueImplementation(int capacity){
        this.capacity = capacity;
        itemArray = new Object[capacity];
        size = front = 0;
    }
    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(T element) throws QueueAllocationException, NullPointerException {
        if(element == null){
            throw new NullPointerException("ERROR");
        }
        if(size == capacity){
            reallocation(capacity + DEFAULT_CAPACITY);
        }
        itemArray[(front + size) % capacity] = element;
        size++;
    }
    private void reallocation(int capacity){
        Object[] newArray = new Object[capacity];
        if(front + size <= this.capacity){
            System.arraycopy(itemArray,front,newArray,0,size);
        }else{
            int copyLen1 = front + size - this.capacity;
            System.arraycopy(itemArray,front,newArray,0,copyLen1);
            System.arraycopy(itemArray,0,newArray,copyLen1,size - copyLen1);
        }
        itemArray = newArray;
        this.capacity = capacity;
        front = 0;
    }

    @Override
    public T dequeue() throws QueueIsEmptyException {
        if(size == 0){
            throw new QueueIsEmptyException("ERROR");
        }
        T val = (T)itemArray[front];
        front++;
        if(front == capacity){
            front = 0;
        }
        size--;
        return val;
    }

    @Override
    public T element() throws QueueIsEmptyException {
        if(size == 0){
            throw new QueueIsEmptyException("ERROR");
        }
        return (T)itemArray[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        front = 0;
        size = 0;
    }
    @Override
    public String toString(){
        T temp;
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < size;i++){
            temp = dequeue();
            sb.append(temp.toString());
            enqueue(temp);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

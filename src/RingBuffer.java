import java.util.Arrays;
//adi bhattacharya
public class RingBuffer {
    private double[] data; // items in the buffer
    private int first; // index for the next dequeue or peek
    private int last; // index for the next enqueue
    private int size; // number of items in the buffer

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
        data = new double[capacity];
        for (int i = 0; i < data.length; i++) {
            data[i] = 0.0;
        }
        first = capacity / 2;
        last = first;
        size = 0;

    }

    /** return number of items currently in the buffer */
    public int size() {
        return size; // REPLACE
    }

    /** is the buffer empty (size equals zero)? */
    public boolean isEmpty() {

        // YOUR CODE HERE
        return size == 0;
        // REPLACE
    }

    /** is the buffer full (size equals array capacity)? */
    public boolean isFull() {
        // YOUR CODE HERE

        return size == data.length; // REPLACE
    }

    /** add item x to the end */
    public void enqueue(double x) throws RuntimeException {
        // YOUR CODE HERE
        if (isFull()) {
            throw new RuntimeException();
        }

        data[last] = x;
        last++;
        if (last == data.length)
            last = 0;

        size++;
    }

    /** delete and return item from the front */
    public double dequeue() throws RuntimeException {
        // YOUR CODE HERE

        if (isEmpty()) {
            throw new RuntimeException();
        }

        double temp = data[first];
        data[first] = 0.0;
        first++;
        if (first == data.length)
            first = 0;
        size--;

        return temp; // REPLACE
    }

    /** return (but do not delete) item from the front */
    public double peek() throws RuntimeException {
        // YOUR CODE HERE
        // if (isEmpty()) {
        //     throw new RuntimeException();
        // }
        return data[first]; // REPLACE
    }

    public String toString() {
        return Arrays.toString(data);
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        // while (!buffer.isEmpty()) {
        // buffer.dequeue();
        // }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }

        System.out.println(buffer.peek());

        /*
         * Your program should produce the following output:
         *
         * Size after wrap-around is 100
         * 5050.0
         */
    }
}

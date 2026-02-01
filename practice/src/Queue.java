public class Queue<T> {
    private T[] elements;
    private int front, rear, size, capacity;

    // Constructor
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue (insert element)
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + item);
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        elements[rear] = item;
        size++;
    }

    // Dequeue (remove element)
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Nothing to dequeue.");
            return null;
        }
        T item = elements[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return item;
    }

    // Peek (view front element)
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return elements[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

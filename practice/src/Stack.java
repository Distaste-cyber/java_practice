public class Stack<T> {
    private int top;
    private T[] elements;
    private int capacity;

    // Constructor
    @SuppressWarnings("unchecked")
    public Stack(int size) {
        capacity = size;
        elements = (T[]) new Object[size]; // Java doesn’t allow generic array creation directly
        top = -1;
    }

    // Push operation
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        elements[++top] = value;
    }

    // Pop operation
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return null;
        }
        return elements[top--];
    }

    // Peek (view top element)
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return elements[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}

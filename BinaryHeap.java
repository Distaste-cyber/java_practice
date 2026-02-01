
import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<Integer> heap;
    private boolean isMinHeap;

    public BinaryHeap(boolean isMinHeap) {
        this.heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (compare(heap.get(current), heap.get(parent))) {
                swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    public int deleteRoot() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }

        int rootValue = heap.get(0);

        // Move last element to root and remove last
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return rootValue;
    }

    // Heapify down (used in deletion)
    private void heapifyDown(int index) {
        int leftChild, rightChild, selectedChild;
        int size = heap.size();

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            selectedChild = index;

            // Compare with left child
            if (leftChild < size && compare(heap.get(leftChild), heap.get(selectedChild))) {
                selectedChild = leftChild;
            }

            // Compare with right child
            if (rightChild < size && compare(heap.get(rightChild), heap.get(selectedChild))) {
                selectedChild = rightChild;
            }

            // If the smallest/largest is not the current index, swap
            if (selectedChild != index) {
                swap(index, selectedChild);
                index = selectedChild;
            } else {
                break;
            }
        }
    }

    private boolean compare(int child, int parent) {
        if (isMinHeap)
            return child < parent;
        else
            return child > parent;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {

        BinaryHeap minHeap = new BinaryHeap(true);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(2);
        minHeap.insert(8);

        System.out.print("Min-Heap: ");
        minHeap.printHeap();

        BinaryHeap maxHeap = new BinaryHeap(false);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(2);
        maxHeap.insert(8);

        System.out.print("Max-Heap: ");
        maxHeap.printHeap();
    }

}

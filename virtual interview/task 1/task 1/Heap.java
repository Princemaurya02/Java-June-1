import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    // Each parent has 2^childrenExponent children
    private final int childCount;
    private final ArrayList<T> data;

    public Heap(int childrenExponent) {
        if (childrenExponent < 0) {
            throw new IllegalArgumentException(
                    "childrenExponent must be non-negative");
        }

        this.childCount = 1 << childrenExponent; // 2^x
        this.data = new ArrayList<>();
    }

    // Insert an item into the heap
    public void insert(T item) {
        data.add(item);

        int currentIndex = data.size() - 1;

        while (currentIndex > 0) {
            int nextIndex = swapUp(currentIndex);

            if (nextIndex == currentIndex) {
                break;
            }

            currentIndex = nextIndex;
        }
    }

    // Move item upward if needed
    private int swapUp(int childIndex) {
        int parentIndex = (childIndex - 1) / childCount;

        T childValue = data.get(childIndex);
        T parentValue = data.get(parentIndex);

        if (childValue.compareTo(parentValue) > 0) {
            data.set(parentIndex, childValue);
            data.set(childIndex, parentValue);
            return parentIndex;
        }

        return childIndex;
    }

    // Remove and return maximum element
    public T popMax() {
        if (data.isEmpty()) {
            return null;
        }

        T maxItem = data.get(0);

        // Only one element
        if (data.size() == 1) {
            data.remove(0);
            return maxItem;
        }

        T lastItem = data.remove(data.size() - 1);
        data.set(0, lastItem);

        int currentIndex = 0;

        while (true) {
            int nextIndex = swapDown(currentIndex);

            if (nextIndex == currentIndex) {
                break;
            }

            currentIndex = nextIndex;
        }

        return maxItem;
    }

    // Move item downward if needed
    private int swapDown(int parentIndex) {
        int largestChildIndex = -1;
        T largestChildValue = null;

        int firstChildIndex = parentIndex * childCount + 1;

        for (int i = 0; i < childCount; i++) {
            int childIndex = firstChildIndex + i;

            if (childIndex >= data.size()) {
                break;
            }

            T childValue = data.get(childIndex);

            if (largestChildValue == null ||
                    childValue.compareTo(largestChildValue) > 0) {
                largestChildValue = childValue;
                largestChildIndex = childIndex;
            }
        }

        if (largestChildIndex == -1) {
            return parentIndex;
        }

        T parentValue = data.get(parentIndex);

        if (parentValue.compareTo(largestChildValue) < 0) {
            data.set(parentIndex, largestChildValue);
            data.set(largestChildIndex, parentValue);
            return largestChildIndex;
        }

        return parentIndex;
    }

    // Peek maximum element
    public T peekMax() {
        if (data.isEmpty()) {
            return null;
        }

        return data.get(0);
    }

    // Heap size
    public int size() {
        return data.size();
    }

    // Check if empty
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Display heap contents
    public void printHeap() {
        System.out.println(data);
    }

    // Test Program
    public static void main(String[] args) {

        // childrenExponent = 2
        // Each parent has 2^2 = 4 children
        Heap<Integer> heap = new Heap<>(2);

        heap.insert(10);
        heap.insert(40);
        heap.insert(15);
        heap.insert(70);
        heap.insert(20);
        heap.insert(100);
        heap.insert(5);
        heap.insert(90);

        System.out.println("Heap:");
        heap.printHeap();

        System.out.println("\nElements removed in descending order:");

        while (!heap.isEmpty()) {
            System.out.print(heap.popMax() + " ");
        }
    }
}
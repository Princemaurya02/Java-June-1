import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PowerOfTwoMaxHeap {

    // Each node has 2^childrenExponent children
    private final int childrenExponent;
    private final int branchingFactor;

    private final List<Integer> heap;

    public PowerOfTwoMaxHeap(int childrenExponent) {
        if (childrenExponent < 0) {
            throw new IllegalArgumentException(
                "childrenExponent must be non-negative"
            );
        }

        this.childrenExponent = childrenExponent;
        this.branchingFactor = 1 << childrenExponent;
        this.heap = new ArrayList<>();
    }

    /**
     * Inserts a value into the heap.
     */
    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    /**
     * Removes and returns the maximum element.
     */
    public int popMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int maxValue = heap.get(0);
        int lastIndex = heap.size() - 1;

        if (lastIndex == 0) {
            heap.remove(lastIndex);
            return maxValue;
        }

        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        siftDown(0);

        return maxValue;
    }

    /**
     * Returns the maximum element without removing it.
     */
    public int peekMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    /**
     * Returns heap size.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns true if heap is empty.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Moves element upward until heap property is restored.
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / branchingFactor;

            if (heap.get(index) <= heap.get(parentIndex)) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * Moves element downward until heap property is restored.
     */
    private void siftDown(int index) {
        int size = heap.size();

        while (true) {
            int largestIndex = index;

            int firstChild = index * branchingFactor + 1;

            for (int offset = 0; offset < branchingFactor; offset++) {
                int childIndex = firstChild + offset;

                if (childIndex >= size) {
                    break;
                }

                if (heap.get(childIndex) > heap.get(largestIndex)) {
                    largestIndex = childIndex;
                }
            }

            if (largestIndex == index) {
                break;
            }

            swap(index, largestIndex);
            index = largestIndex;
        }
    }

    /**
     * Swaps two heap elements.
     */
    private void swap(int firstIndex, int secondIndex) {
        int temp = heap.get(firstIndex);
        heap.set(firstIndex, heap.get(secondIndex));
        heap.set(secondIndex, temp);
    }

    /**
     * Simple test.
     */
    public static void main(String[] args) {

        // x = 2 => each parent has 2^2 = 4 children
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2);

        heap.insert(10);
        heap.insert(40);
        heap.insert(15);
        heap.insert(70);
        heap.insert(20);
        heap.insert(100);
        heap.insert(5);

        while (!heap.isEmpty()) {
            System.out.print(heap.popMax() + " ");
        }

        // Output:
        // 100 70 40 20 15 10 5
    }
}
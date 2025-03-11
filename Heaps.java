
import java.util.ArrayList;

public class Heaps {
    static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int x) {
            heap.add(x);
            int childIdx = heap.size() - 1;
            int parentIdx = (childIdx - 1) / 2;
            while (heap.get(childIdx) < heap.get(parentIdx)) {
                int temp = heap.get(childIdx);
                heap.set(childIdx, heap.get(parentIdx));
                heap.set(parentIdx, temp);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        public void print() {
            System.out.println(heap);
        }

        public int remove() {
            // The remove method removes the first index and rearranges the heap according
            // to the min heap rules

            int removedData = heap.get(0);

            // below the first and last element are being swapped
            heap.set(0, heap.get(heap.size() - 1));
            heap.set(heap.size() - 1, removedData);
            heap.remove(heap.size() - 1);

            // heapify method checks if the swaped number has the condition for the min heap
            heapify(0);
            return removedData;
        }

        private void heapify(int i) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int minIdx = i;

            if (leftChild < heap.size() && heap.get(minIdx) > heap.get(leftChild)) {
                minIdx = leftChild;
            }
            if (rightChild < heap.size() && heap.get(minIdx) > heap.get(rightChild)) {
                minIdx = rightChild;
            }
            if (minIdx != i) {
                int temp = heap.get(i);
                heap.set(i, heap.get(minIdx));
                heap.set(minIdx, temp);
                // This statement checks if the minInx element holds good for the min heap
                // conditions
                heapify(minIdx);
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(1);
        heap.add(2);
        heap.add(8);
        heap.add(4);
        heap.print();

        heap.remove();
        heap.print();
    }
}

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;
    
    public MyMinHeap() {
        // Using MyArrayList for random access which is helpful for heap operations
        heap = new MyArrayList<>();
    }
    
    // Add an item to the heap
    public void add(T item) {
        // Add at the end
        heap.add(item);
        
        // Heapify up
        int index = heap.size() - 1;
        heapifyUp(index);
    }
    
    // Get the minimum element (root)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        return heap.get(0);
    }
    
    // Remove and return the minimum element
    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        T min = heap.get(0);
        
        // Replace root with the last element
        T lastItem = heap.getLast();
        heap.set(0, lastItem);
        heap.removeLast();
        
        // Heapify down if heap is not empty
        if (!isEmpty()) {
            heapifyDown(0);
        }
        
        return min;
    }
    
    // Check if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    
    // Get the size of the heap
    public int size() {
        return heap.size();
    }
    
    // Clear the heap
    public void clear() {
        heap.clear();
    }
    
    // Helper method for heapify up
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        
        // If current is smaller than parent, swap and continue up
        if (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }
    
    // Helper method for heapify down
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        
        // Find the smallest among parent, left child, and right child
        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }
        
        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }
        
        // If smallest is not the parent, swap and continue down
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    
    // Helper method to swap two elements
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
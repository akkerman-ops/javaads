public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;
    
    public MyQueue() {
        // Using MyLinkedList for O(1) operations at both ends
        list = new MyLinkedList<T>();
    }
    
    // Add item to the end of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }
    
    // Remove item from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    
    // Look at the front item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        return list.getFirst();
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    // Get the size of the queue
    public int size() {
        return list.size();
    }
    
    // Clear the queue
    public void clear() {
        list.clear();
    }
}
public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;
    
    public MyStack() {
        // Using MyArrayList for O(1) add/remove at the end
        list = new MyArrayList<T>();
    }
    
    // Push an item onto the stack
    public void push(T item) {
        list.addLast(item);
    }
    
    // Pop an item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        
        T item = list.getLast();
        list.removeLast();
        return item;
    }
    
    // Look at the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        
        return list.getLast();
    }
    
    // Check if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    // Get the size of the stack
    public int size() {
        return list.size();
    }
    
    // Clear the stack
    public void clear() {
        list.clear();
    }
}
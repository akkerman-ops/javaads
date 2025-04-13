public class TestMyCollections {

    // Test for MyArrayList
public static void runTestMyArrayList() {
    System.out.println("Testing MyArrayList:");
    MyArrayList<String> list = new MyArrayList<>();
    
    // Test add
    list.add("A");
    list.add("B");
    list.add("C");
    System.out.println("After adding A, B, C: " + arrayToString(list.toArray()));
    
    // Test get
    System.out.println("Element at index 1: " + list.get(1));
    
    // Test add at index
    list.add(1, "D");
    System.out.println("After adding D at index 1: " + arrayToString(list.toArray()));
    
    // Test addFirst and addLast
    list.addFirst("E");
    list.addLast("F");
    System.out.println("After adding E at first and F at last: " + arrayToString(list.toArray()));
    
    // Test getFirst and getLast
    System.out.println("First element: " + list.getFirst());
    System.out.println("Last element: " + list.getLast());
    
    // Test set
    list.set(2, "G");
    System.out.println("After setting index 2 to G: " + arrayToString(list.toArray()));
    
    // Test remove
    list.remove(1);
    System.out.println("After removing element at index 1: " + arrayToString(list.toArray()));
    
    // Test removeFirst and removeLast
    list.removeFirst();
    list.removeLast();
    System.out.println("After removing first and last elements: " + arrayToString(list.toArray()));
    
    // Test sort
    list.add("Z");
    list.add("X");
    list.sort();
    System.out.println("After sorting: " + arrayToString(list.toArray()));
    
    // Test indexOf and lastIndexOf
    list.add("A");
    System.out.println("Index of A: " + list.indexOf("A"));
    System.out.println("Last index of A: " + list.lastIndexOf("A"));
    
    // Test exists
    System.out.println("Exists 'G': " + list.exists("G"));
    System.out.println("Exists 'Y': " + list.exists("Y"));
    
    // Test size
    System.out.println("Size: " + list.size());
    
    // Test clear
    list.clear();
    System.out.println("After clearing, size: " + list.size());
}

// Test for MyLinkedList
public static void testMyLinkedList() {
    System.out.println("\nTesting MyLinkedList:");
    MyLinkedList<String> list = new MyLinkedList<>();
    
    // Test add
    list.add("A");
    list.add("B");
    list.add("C");
    System.out.println("After adding A, B, C: " + arrayToString(list.toArray()));
    
    // Test get
    System.out.println("Element at index 1: " + list.get(1));
    
    // Test add at index
    list.add(1, "D");
    System.out.println("After adding D at index 1: " + arrayToString(list.toArray()));
    
    // Test addFirst and addLast
    list.addFirst("E");
    list.addLast("F");
    System.out.println("After adding E at first and F at last: " + arrayToString(list.toArray()));
    
    // Test getFirst and getLast
    System.out.println("First element: " + list.getFirst());
    System.out.println("Last element: " + list.getLast());
    
    // Test set
    list.set(2, "G");
    System.out.println("After setting index 2 to G: " + arrayToString(list.toArray()));
    
    // Test remove
    list.remove(1);
    System.out.println("After removing element at index 1: " + arrayToString(list.toArray()));
    
    // Test removeFirst and removeLast
    list.removeFirst();
    list.removeLast();
    System.out.println("After removing first and last elements: " + arrayToString(list.toArray()));
    
    // Test sort
    list.add("Z");
    list.add("X");
    list.sort();
    System.out.println("After sorting: " + arrayToString(list.toArray()));
    
    // Test indexOf and lastIndexOf
    list.add("A");
    System.out.println("Index of A: " + list.indexOf("A"));
    System.out.println("Last index of A: " + list.lastIndexOf("A"));
    
    // Test exists
    System.out.println("Exists 'G': " + list.exists("G"));
    System.out.println("Exists 'Y': " + list.exists("Y"));
    
    // Test size
    System.out.println("Size: " + list.size());
    
    // Test clear
    list.clear();
    System.out.println("After clearing, size: " + list.size());
}

// Test for MyStack
public static void testMyStack() {
    System.out.println("\nTesting MyStack:");
    MyStack<String> stack = new MyStack<>();
    
    // Test push
    stack.push("A");
    stack.push("B");
    stack.push("C");
    System.out.println("After pushing A, B, C, size: " + stack.size());
    
    // Test peek
    System.out.println("Top element: " + stack.peek());
    
    // Test pop
    System.out.println("Popped: " + stack.pop());
    System.out.println("After popping, size: " + stack.size());
    System.out.println("Top element: " + stack.peek());
    
    // Test clear
    stack.clear();
    System.out.println("After clearing, isEmpty: " + stack.isEmpty());
}

// Test for MyQueue
public static void testMyQueue() {
    System.out.println("\nTesting MyQueue:");
    MyQueue<String> queue = new MyQueue<>();
    
    // Test enqueue
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    System.out.println("After enqueueing A, B, C, size: " + queue.size());
    
    // Test peek
    System.out.println("Front element: " + queue.peek());
    
    // Test dequeue
    System.out.println("Dequeued: " + queue.dequeue());
    System.out.println("After dequeuing, size: " + queue.size());
    System.out.println("Front element: " + queue.peek());
    
    // Test clear
    queue.clear();
    System.out.println("After clearing, isEmpty: " + queue.isEmpty());
}

// Test for MyMinHeap
public static void testMyMinHeap() {
    System.out.println("\nTesting MyMinHeap:");
    MyMinHeap<Integer> heap = new MyMinHeap<>();
    
    // Test add
    heap.add(5);
    heap.add(2);
    heap.add(8);
    heap.add(1);
    heap.add(7);
    System.out.println("After adding 5, 2, 8, 1, 7, size: " + heap.size());
    
    // Test peek
    System.out.println("Min element: " + heap.peek());
    
    // Test poll
    System.out.println("Polled min: " + heap.poll());
    System.out.println("After polling, size: " + heap.size());
    System.out.println("New min element: " + heap.peek());
    
    // Test clear
    heap.clear();
    System.out.println("After clearing, isEmpty: " + heap.isEmpty());
}
public static String arrayToString(Object[] array) {
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < array.length; i++) {
        result.append(array[i]);
        if (i < array.length - 1) {
            result.append(", ");
        }
    }
    result.append("]");
    return result.toString();
}

// Main method to run tests
public static void main(String[] args) {
    runTestMyArrayList();
    testMyLinkedList();
    testMyStack();
    testMyQueue();
    testMyMinHeap();
}
}
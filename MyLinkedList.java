public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T element;
        Node next;
        Node prev;

        Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node current = getNodeAt(index);
            
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index).element;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return tail.element;
    }

    @Override
    public void set(int index, T item) {
        Node node = getNodeAt(index);
        node.element = item;
    }

    @Override
    public void remove(int index) {
        Node nodeToRemove = getNodeAt(index);
        
        if (nodeToRemove == head) {
            removeFirst();
        } else if (nodeToRemove == tail) {
            removeLast();
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            
            // Help garbage collection
            nodeToRemove.next = null;
            nodeToRemove.prev = null;
            
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node next = head.next;
            next.prev = null;
            
            // Help garbage collection
            head.next = null;
            
            head = next;
        }
        
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node prev = tail.prev;
            prev.next = null;
            
            // Help garbage collection
            tail.prev = null;
            
            tail = prev;
        }
        
        size--;
    }

    @Override
    public void sort() {
        // For linked list, let's use insertion sort which works well for linked structures
        if (size <= 1) {
            return;
        }
        
        // Create a new sorted list
        MyLinkedList<T> sorted = new MyLinkedList<>();
        
        // Iterate through the original list
        Node current = head;
        while (current != null) {
            T element = current.element;
            Node next = current.next;
            
            // Insert into sorted list
            if (sorted.size() == 0 || ((Comparable<T>)element).compareTo(sorted.getFirst()) <= 0) {
                sorted.addFirst(element);
            } else if (((Comparable<T>)element).compareTo(sorted.getLast()) >= 0) {
                sorted.addLast(element);
            } else {
                Node sortedCurrent = sorted.head;
                int index = 0;
                
                while (((Comparable<T>)element).compareTo(sortedCurrent.element) > 0) {
                    sortedCurrent = sortedCurrent.next;
                    index++;
                }
                
                sorted.add(index, element);
            }
            
            current = next;
        }
        
        // Replace this list with the sorted list
        this.head = sorted.head;
        this.tail = sorted.tail;
        // Don't change size as it should remain the same
    }
    
    public void sort(java.util.Comparator<T> comparator) {
        if (size <= 1) {
            return;
        }
        
        // Create a new sorted list
        MyLinkedList<T> sorted = new MyLinkedList<>();
        
        // Iterate through the original list
        Node current = head;
        while (current != null) {
            T element = current.element;
            Node next = current.next;
            
            // Insert into sorted list
            if (sorted.size() == 0 || comparator.compare(element, sorted.getFirst()) <= 0) {
                sorted.addFirst(element);
            } else if (comparator.compare(element, sorted.getLast()) >= 0) {
                sorted.addLast(element);
            } else {
                Node sortedCurrent = sorted.head;
                int index = 0;
                
                while (comparator.compare(element, sortedCurrent.element) > 0) {
                    sortedCurrent = sortedCurrent.next;
                    index++;
                }
                
                sorted.add(index, element);
            }
            
            current = next;
        }
        
        // Replace this list with the sorted list
        this.head = sorted.head;
        this.tail = sorted.tail;
    }

    @Override
    public int indexOf(Object object) {
        Node current = head;
        int index = 0;
        
        while (current != null) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node current = tail;
        int index = size - 1;
        
        while (current != null) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node current = head;
        int index = 0;
        
        while (current != null) {
            result[index++] = current.element;
            current = current.next;
        }
        
        return result;
    }

    @Override
    public void clear() {
        // Clear references to help GC
        Node current = head;
        
        while (current != null) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node current;
        
        // Optimize by starting from the closest end
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current;
    }
    
    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }
    
    private class Iterator implements java.util.Iterator<T> {
        private Node current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            
            T element = current.element;
            current = current.next;
            return element;
        }
    }
}
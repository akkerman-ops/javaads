public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        ensureCapacity(size + 1);
        
        // Shift elements to make space for the new element
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[size - 1];
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        
        // Shift elements to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        
        elements[size - 1] = null; // Help garbage collection
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        remove(size - 1);
    }

    @Override
    public void sort() {
        // Using simple bubble sort for generic types
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) get(j)).compareTo(get(j + 1)) > 0) {
                    // Swap elements
                    T temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }
    
    public void sort(java.util.Comparator<T> comparator) {
        // Using bubble sort with comparator
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(get(j), get(j + 1)) > 0) {
                    // Swap elements
                    T temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null ? elements[i] == null : object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object == null ? elements[i] == null : object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    @Override
    public void clear() {
        // Clear references to help GC
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2; // Double the capacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }
    
    private class Iterator implements java.util.Iterator<T> {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return (T) elements[currentIndex++];
        }
    }
}
# Data Structures Implementation

This project implements several data structures from scratch without using Java's built-in collection classes (except for Iterator).

## Overview

The implementation consists of two physical data structures:
- `MyArrayList`: An array-based implementation of a list
- `MyLinkedList`: A doubly linked list implementation

And three logical data structures built on top of the physical ones:
- `MyStack`: A Last-In-First-Out (LIFO) data structure
- `MyQueue`: A First-In-First-Out (FIFO) data structure  
- `MyMinHeap`: A min-heap implementation for priority queue operations

## Structure

### MyList Interface

The core interface that defines the common operations for list-based data structures:

```java
public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}
```

### Physical Data Structures

#### MyArrayList

An array-based implementation with dynamic resizing:
- Uses an Object array to store elements
- Provides O(1) access time for get/set operations
- Resizes the array when capacity is exceeded
- Implements all methods defined in the MyList interface

#### MyLinkedList

A doubly linked list implementation:
- Maintains head and tail pointers
- Provides O(1) insertion/deletion at both ends
- Implements bidirectional traversal
- Prevents loop creation
- Implements all methods defined in the MyList interface

### Logical Data Structures

#### MyStack

A stack implementation:
- Built on top of `MyArrayList` for efficient operations
- Provides push, pop, and peek operations
- O(1) time complexity for all operations

#### MyQueue

A queue implementation:
- Built on top of `MyLinkedList` for efficient operations at both ends
- Provides enqueue, dequeue, and peek operations
- O(1) time complexity for all operations

#### MyMinHeap

A min-heap implementation:
- Built on top of `MyArrayList` for efficient parent-child element access
- Provides add, peek, and poll operations
- O(log n) time complexity for add and poll operations
- O(1) time complexity for peek operation
- Maintains the heap property where parent elements are smaller than their children

## Implementation Details

### MyArrayList Implementation

- Uses an array with dynamic resizing (doubles capacity when needed)
- Shifting elements when inserting/removing at specific indices
- Implements the Iterator interface for enhanced for-loop support

### MyLinkedList Implementation

- Uses nodes with references to both previous and next nodes
- Optimizes traversal by approaching from the closest end (head or tail)
- Provides special handling for edge cases (empty list, single element)

### Sort Implementation

- MyArrayList uses bubble sort
- MyLinkedList uses insertion sort
- Both support sorting with a Comparator

## Testing

Each data structure includes comprehensive test methods to verify:
- Element addition, retrieval, and removal
- Index operations
- Element search operations
- Edge cases handling


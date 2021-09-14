package _09_dsa_list.exercise.implement_method_of_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        else if (index >= size || index <0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        size++;
        for (int i = size;i>index;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

//    public E remove(int index){
//
//    }
    public int size(){
        return size;
    }
//    public E clone(){
//
//    }
//    boolean contains(E o){
//
//    }
//    int indexOf(E o){
//
//    }
//    boolean add(E e) {
//
//    }
//    void ensureCapacity(int minCapacity) {
//
//    }
//
//    void clear(){
//
//    }
}

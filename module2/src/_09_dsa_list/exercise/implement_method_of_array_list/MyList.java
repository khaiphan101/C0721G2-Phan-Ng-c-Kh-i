package _09_dsa_list.exercise.implement_method_of_array_list;

import _09_dsa_list.exercise.implement_method_of_linked_list.MyLinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public int size(){
        return size;
    }

    public void add(int index,E e) {
        if (index> size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        } else {
            if (size == elements.length) {
                ensureCapa();
            }
            size++;
            for (int i = size;i>index;i--){
                elements[i] = elements[i-1];
            }
            elements[index] = e;
        }
    }

    public E remove(int index) {
        if (index > size || index <0) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
        } else {
            Object temp = elements[index];
            for (int i = index; i < size-1;i++) {
                elements[i] = elements[i+1];
            }
            elements[size] = null;
            size--;
            return (E) temp;
        }
    }
    public MyList<E> clone(){
        MyList<E> clone = new MyList<E>();
        if (size ==0) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i< size; i++) {
                clone.add(i, (E) elements[i]);
            }
        }
        return clone;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if(o == elements[i]) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if(o == elements[i]) {
                return i;
            }
        }
        return -1;
    }
    public void clear(){
        for (int i = 0; i < size; i++)
            elements[i] = null;

        size = 0;
    }
}

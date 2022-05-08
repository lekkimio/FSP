package com.company;



import java.util.*;

public class MyArrayList<E>{

    private E[] array;
    private int size;

    public MyArrayList() {
        array = (E[]) new Object[0];
        size = 0;
    }

    public MyArrayList(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }


    @Override
    public String toString() {
        E[] arr = (E[]) new Object[size];
        for (int i = 0; i <array.length;i++)
            if(array[i] != null)
                arr[i]=array[i];
        return Arrays.toString(arr);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
         E[] temp = (E[]) new Object[array.length + array.length / 2];
         System.arraycopy(array, 0, temp, 0, array.length);
         array = temp;
         array[size] = e;
         size++;
         return true;
    }

    public void add(int index, E element) {
        sizeCheck(index);
        add(element);
        if (size - 1 - index >= 0)
            System.arraycopy(array, index, array,
                    index + 1, size - 1 - index);
        array[index] = element;
    }

    private void sizeCheck(int index) {
        if(index<0 || index>=size )
            throw new IndexOutOfBoundsException("Index "+ index +" out of " +
                    "bounds for size " + size );
        else if(array[index] == null){
            throw new IllegalArgumentException();}
    }

    public void clear() {
        Object[] clear = array;
        for (int i = size, j = size = 0; j < i; j++)
            clear[j] = null;
    }

    public E get(int index) {
        sizeCheck(index);
        return array[index];
    }

    public E set(int index, E element) {
        sizeCheck(index);
        E remObj = array[index];
        array[index] = element;
        return remObj;
    }

    public E remove(int index) {
        sizeCheck(index);
        E remObj = array[index];
        if (size - index >= 0)
            System.arraycopy(array, index + 1, array,
                    index, size - index);
        size--;
        return remObj;
    }

    public boolean remove(Object o) {
        int roInx = indexOf(o);
        sizeCheck(roInx);

        E[] temp = (E[]) new Object[array.length + array.length / 2];
        int i = 0;
        while (i < array.length) {
            if (i == roInx) break;
            temp[i] = array[i];
            i++;
        }

        if (array.length - (roInx + 1) >= 0)
            System.arraycopy(array, roInx + 1, temp,
                    roInx + 1 - 1, array.length - (roInx + 1));

        array = temp;
        size--;
        return true;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o))
                return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        for (int i = 0; i<size; i++) {
            if(array[i].equals(o))
                return true;
        }
        return false;
    }

    //TODO: all that

    public void trimToSize(){

    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }


    public Iterator<E> iterator() {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }


    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }


    public boolean removeAll(Collection<?> c) {
        return false;
    }


    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public ListIterator<E> listIterator() {
        return null;
    }


    public ListIterator<E> listIterator(int index) {
        return null;
    }


    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}

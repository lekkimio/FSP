package com.company;

import java.util.*;

public class MyArrayList<E> implements List<E>{

    private E[] array;
    private int size;
    private E[] temp;

    public MyArrayList() {
        array = (E[]) new Object[10];
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
        ensureCapacity();
        array[size] = e;
        size++;
        return true;
    }

    public void add(int index, E element) {
        capacCheck(index);
        if (size - index >= 0) {
            System.arraycopy(array, index, array,
                    index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void ensureCapacity() {
        if (size < array.length){
            temp = (E[]) new Object[array.length];
        }
        else {
            temp = (E[]) new Object[array.length + array.length / 2];
        }
        temp = Arrays.copyOf(array,temp.length);
        array = temp;
    }

    private void capacCheck(int index) {
        if(index < 0 || index > size )
            throw new IndexOutOfBoundsException("Index "+ index +" out of " +
                    "bounds for size " + size );
        else {if (size == array.length){
            ensureCapacity();
             }
        }

    }

    public void clear() {
        Object[] clear = array;
        for (int i = size, j = size = 0; j < i; j++)
            clear[j] = null;
        trimToSize();
    }

    public E get(int index) {
        capacCheck(index);
        return array[index];
    }

    public E set(int index, E element) {
        capacCheck(index);
        E remObj = array[index];
        array[index] = element;
        return remObj;
    }

    public E remove(int index) {
        capacCheck(index);
        E remObj = array[index];
        if (size - index >= 0)
            System.arraycopy(array, index + 1, array,
                    index, size - index);
        size--;
        return remObj;
    }

    public boolean remove(Object o) {
        int roInx = indexOf(o);
        E[] temp = (E[]) new Object[array.length-1];
        int i = 0;
        while (i < array.length) {
            if (i == roInx) break;{
                temp[i] = array[i];
                i++;
            }
        }

        if (array.length - (roInx + 1) >= 0) {
            System.arraycopy(array, roInx + 1, temp,
                    roInx + 1 - 1, array.length - (roInx + 1));
        }
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

    public void trimToSize(){
        if(size<array.length){
            if (size==0){
                clear();
            }
            else {
                array = Arrays.copyOf(array, size);}
        }
    }

    public <T> T[] toArray(T[] a) {
        if(a.length < size){
                return (T[]) Arrays.copyOf(array, size, a.getClass());
            }
        System.arraycopy(array,0,a,0,size);
           if (a.length>size){
               a[size] =null;
           }
        return a;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        capacCheck(index);

        Object[] tempArr = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            add(index, (E) tempArr[i]);
            index++;
        }

        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        ensureCapacity();

        E[] tempArr = (E[]) c.toArray();
        int tempSize = tempArr.length;
        if(tempSize == 0 || tempArr[0] == null){
            return false;}

        for (int i = 0; i < c.size(); i++) {
            add((E) tempArr[i]);
        }

        return true;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array,size);
    }

    public boolean contains(Object o) {
        Iterator<E> it = iterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {

        Object[] tempArr = new Object[size];
        Object[] colArr = c.toArray();
        for (Object o : colArr) {
            for (int i = 0; i < size; i++) {
                if (o == array[i]) {
                    remove(i);
                }
            }
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        Object[] tempArr = new Object[size];
        Object[] colArr = c.toArray();
        int inx = 0;
        for (Object o : colArr) {
            for (int i = 0; i < size; i++) {
                if (o == array[i]) {
                    tempArr[inx] = array[i];
                    inx++;
                }
            }
        }
        size = inx;
        System.arraycopy(tempArr,0,array,0,size);
        trimToSize();

        return true;
    }

    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    public Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E> {
        int index;
        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            return array[index];
        }

    }

    public Object[] clone() {
        E[] clone;
        try {
            clone = (E[]) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone = Arrays.copyOf(array, size);
        return clone;
    }

    //TODO:

    public boolean containsAll(Collection<?> c) {
        //TODO: containsAll
        return false;
    }

    //TODO: ListIterator
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }
    private class ListItr extends Itr implements ListIterator<E> {


        public ListItr(int index) {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    //TODO: SubList
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
        return new SubList<E>(fromIndex,toIndex);
    }
    private class SubList<E> implements List<E> {
        public SubList(int fromIndex, int toIndex) {
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public E set(int index, E element) {
            return null;
        }

        @Override
        public void add(int index, E element) {

        }

        @Override
        public E remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<E> listIterator() {
            return null;
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }
    }

    //TODO: sort
    public void sort(Comparator<? super E> c){}
}

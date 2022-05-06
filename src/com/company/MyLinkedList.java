package com.company;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private E removeFirstEl(Node<E> h){
        E value = h.value;
        Node<E> next = h.next;
        head = next;
        if(next == null){
            tail = null;
        }
        else {
            next.prev=null;
        }
        size--;
        return value;
    }
    private E removeLastEl(Node<E> t) {
        E value = t.value;
        Node<E> prev = t.prev;
        tail = prev;
        if(prev == null){
            head = null;
        }
        else {
            prev.next=null;
        }
        size--;
        return value;
    }

//    private void addFirst(E element) {
//        Node<E> h = head;
//        Node<E> newNode = new Node<>(element, h, null);
//        head = newNode;
//        if (h == null)
//            tail = newNode;
//        else
//            h.prev = newNode;
//        size++;
//    }
    private void addLast(E element) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(element, null, t);
        tail = newNode;
        if (t == null)
            head = newNode;
        else
            t.next = newNode;
        size++;
    }
    private void addAfore(E element, Node<E> node) {
        Node<E> af = node.prev;
        Node<E> newNode = new Node<>(element, node, af);
        node.prev = newNode;
        if (af == null)
            head = newNode;
        else
            af.next = newNode;
        size++;
    }

    public boolean add(E value){
        addLast(value);
        return true;
    }
    public E get(int index){
        int currentIndex = 0;
        Node<E> temp = head;

        while (temp != null){
            if (currentIndex == index){
                return temp.value;
            }else {
                temp = temp.next;
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }
    public E remove(int index){
        if (index == 0){
            head = head.getNext();
            size--;
            return null;
        }

        int currentIndex = 0;
        Node<E> temp = head;

        while (temp != null){
            if (currentIndex == index-1){
                temp.setNext(temp.getNext().getNext());
                size--;
                return null;
            }else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    public E remove(){
        Node<E> h = head;
        if (h == null){
            throw new NoSuchElementException();
        }
        return removeFirstEl(h);
    }
    public E removeFirst(){
        return remove();
    }
    public E removeLast(){
        final Node<E> t = tail;
        if (t == null){
            throw new NoSuchElementException();
        }
         return removeLastEl(t);
    }



    @Override
    public void clear() {
        for(Node<E> h = head; h != null;){
            Node<E> n = h.next;
            h.value = null;
            h = n;
        }
        head = tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public  Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E> {

        int index = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            try {
                int i = index;
                E next = get(i);
                lastRet = i;
                index = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e);
            }
        }
    }

    public String toString(){
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }


    @Override
    public void add(int index, E element) {
        checkIndex(index);

        if (index == size){
            addLast(element);
        }else {
            addAfore(element, Node(index));
        }
    }
    private void checkIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException();
    }
    Node<E> Node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    //TODO: all that

    @Override
    public E set(int index, E element) {
        return null;
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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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

    private static class Node<E>{

        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}

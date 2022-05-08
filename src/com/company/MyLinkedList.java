package com.company;

import java.util.*;

public class MyLinkedList<E>{

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

    private void addFirst(E element) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(element, h, null);
        head = newNode;
        if (h == null)
            tail = newNode;
        else
            h.prev = newNode;
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

    public boolean add(E value){
        addLast(value);
        return true;
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
        Node<E> t = tail;
        if (t == null){
            throw new NoSuchElementException();
        }
        return removeLastEl(t);
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

    public E getFirst(){

        return head.getValue();
    }

    public E getLast(){
        return tail.getValue();
    }

    public void clear() {
        for(Node<E> h = head; h != null;){
            Node<E> n = h.next;
            h.value = null;
            h = n;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private     Iterator<E> iterator() {
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

    public void add(int index, E element) {
        if (!(index >= 0 && index <= size)){
            throw new IndexOutOfBoundsException();}

        if (index == size){
            addLast(element);
        }else {
            addAfore(element, Node(index));
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator<E> iterator = iterator();
        if (o == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null)
                    return true;
            }
        } else {
            while (iterator.hasNext()) {
                if (o.equals(iterator.next()))
                    return true;
            }
        }
        return false;
    }

    public E set(int index, E element) {
        if (!(index >= 0 && index <= size)){
            throw new IndexOutOfBoundsException();}

        Node<E> node = Node(index);
        E val = node.value;
        node.value = element;

        return val;
    }

    public boolean remove(Object o) {
        Iterator<E> iterator = iterator();
        if (o == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null)
                    iterator.remove();
                return true;
            }
        } else {
            while (iterator.hasNext()) {
                if (o.equals(iterator.next())) {
                    iterator.remove();
                }
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {

        Object[] nodeArr = new Object[size];
        int index = 0;
        for (Node<E> t = head; t!=null ; t=t.next) {
            nodeArr[index++]=t.value;
        }

        return nodeArr;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> temp = head; temp != null; temp = temp.next) {
                if (temp.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> temp = head; temp != null; temp = temp.next) {
                if (o.equals(temp.value)) {
                    return index;
                }
                index++;
            }

        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> temp = tail; temp != null; temp = temp.prev) {
                if (temp.value == null) {
                    return index;
                }
                index--;
            }
        } else {
            for (Node<E> temp = tail; temp != null; temp = temp.prev) {
                if (o.equals(temp.value)) {
                    return index;
                }
                index--;
            }

        }
        return -1;
    }

    public <T> T[] toArray(T[] a) {
        if(a.length < size){
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        Object[] nodeArr = a;
        int index = 0;
        for (Node<E> t = head; t!=null ; t=t.next) {
            nodeArr[index++]=t.value;
        }

        return a;
    }

    //Node class and Obj
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

    private Node<E> Node(int index) {
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

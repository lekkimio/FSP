package com.company;

import java.util.*;
import java.util.function.Consumer;

public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    //Node class and Obj
    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    //methods

    private Node<E> Node(int index) {
        Node<E> value;
        if (index < (size >> 1)) {
            value = head;
            for (int i = 0; i < index; i++)
                value = value.next;
        } else {
            value = tail;
            for (int i = size - 1; i > index; i--)
                value = value.prev;
        }
        return value;
    }

    private E removeFirstEl() {
        E value = head.value;
        Node<E> next = head.next;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;
        return value;
    }

    private E removeLastEl() {
        E value = tail.value;
        Node<E> prev = tail.prev;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        size--;
        return value;
    }

    private void addFirst(E element) {
        Node<E> h = head;
        Node<E> newHead = new Node<>(element, h, null);
        head = newHead;
        if (h == null)
            tail = newHead;
        else
            h.prev = newHead;
        size++;
    }

    private void addBefore(E element, Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> newNode = new Node<>(element, node, prev);
        node.prev = newNode;
        if (prev == null)
            head = newNode;
        else
            prev.next = newNode;
        size++;
    }

    private void addLast(E element) {
        Node<E> t = tail;
        Node<E> newTail = new Node<>(element, null, t);
        tail = newTail;
        if (t == null)
            head = newTail;
        else
            t.next = newTail;
        size++;
    }

    private E clearNode(Node<E> node) {
        final E remVal = node.value;
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.value = null;
        size--;

        return remVal;
    }

    public boolean add(E value) {
        if (value == null){
            return false;}
        addLast(value);
        return true;
    }

    public E remove(int index) {
        if (index == 0) {
            head = tail = null;
            size--;
            return null;
        }

        Node<E> rmvObj = Node(index);
        remove(rmvObj.value);

        return null;
    }

    public E remove() {
        Node<E> h = head;
        if (h == null) {
            throw new NoSuchElementException();
        }
        return removeFirstEl();
    }

    public E removeFirst() {
        return remove();
    }

    public E removeLast() {
        Node<E> t = tail;
        if (t == null) {
            throw new NoSuchElementException();
        }
        return removeLastEl();
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> temp = head; temp != null; temp = temp.next) {
                if (temp.value == null) {
                    clearNode(temp);
                    return true;
                }
            }
        } else {
            for (Node<E> temp = head; temp != null; temp = temp.next) {
                if (o.equals(temp.value)) {
                    clearNode(temp);
                    return true;
                }
            }
        }
        return false;
    }

    public E get(int index) {
        int currentIndex = 0;
        Node<E> temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.value;
            } else {
                temp = temp.next;
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public E getFirst() {
        return head.value;
    }

    public E getLast() {
        return tail.value;
    }

    public void clear() {
        for (Node<E> h = head; h != null; ) {
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

    public String toString() {
        StringBuilder toStr = new StringBuilder();
        if (size() > 0) {
            for (Node<E> itr = head; itr != tail; itr = itr.next) {
                toStr.append(itr.value).append(", ");
            }
            toStr.append(tail.value).append("]");

            return "[" + toStr;
        }
        return "[]";

    }


    public void add(int index, E element) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            addLast(element);
        } else {
            addBefore(element, Node(index));
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
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = Node(index);
        E val = node.value;
        node.value = element;

        return val;
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> temp = tail; temp != null; temp = temp.prev) {
                if (temp.value == null) {
                    clearNode(temp);
                    return true;
                }
            }
        } else {
            for (Node<E> temp = tail; temp != null; temp = temp.prev) {
                if (o.equals(temp.value)) {
                    clearNode(temp);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peek() {
        return (head == null) ? null : head.value;
    }

    public E peekFirst() {
        return (head == null) ? null : head.value;
    }

    public E peekLast() {
        return (tail == null) ? null : tail.value;
    }

    public E poll() {
        return (head == null) ? null : removeFirstEl();
    }

    public E pollFirst() {
        return (head == null) ? null : removeFirstEl();
    }

    public E pollLast() {
        return (tail == null) ? null : removeLastEl();
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    public E element() {
        return getFirst();
    }

    public Object[] toArray() {

        Object[] nodeArr = new Object[size];
        int index = 0;
        for (Node<E> t = head; t != null; t = t.next) {
            nodeArr[index++] = t.value;
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
                index--;
                if (temp.value == null) {
                    return index;
                }
            }
        } else {
            for (Node<E> temp = tail; temp != null; temp = temp.prev) {
                index--;
                if (o.equals(temp.value)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        Object[] nodeArr = a;
        int index = 0;
        for (Node<E> t = head; t != null; t = t.next) {
            nodeArr[index++] = t.value;
        }

        return a;
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {

        int ind = index;
        for (Object o : c) {
            add(ind, (E) o);
            ind++;
        }
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        Iterator<?> it = listIterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    public boolean retainAll(Collection<?> c) {
        boolean removed = false;
        Iterator<?> it = listIterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int index;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E next = get(index);
            lastRet = index;
            index += 1;
            return next;

        }

    }

    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastRet;
        private Node<E> next;
        private int currInx;

        ListItr(int index) {
            next = (index == size) ? null : Node(index);
            currInx = index;
        }

        public boolean hasNext() {
            return currInx < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastRet = next;
            next = next.next;
            currInx++;
            return lastRet.value;
        }

        public boolean hasPrevious() {
            return currInx > 0;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastRet = next = (next == null) ? tail : next.prev;
            currInx--;
            return lastRet.value;
        }

        public int nextIndex() {
            return currInx;
        }

        public int previousIndex() {
            return currInx - 1;
        }

        public void remove() {
            if (lastRet == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastRet.next;
            clearNode(lastRet);
            if (next == lastRet)
                next = lastNext;
            else
                currInx--;
            lastRet = null;
        }

        public void set(E e) {
            if (lastRet == null)
                throw new IllegalStateException();
            lastRet.value = e;
        }

        public void add(E e) {
            lastRet = null;
            if (next == null)
                addLast(e);
            else
                addBefore(e, next);
            currInx++;
        }
    }

    public Iterator<E> descendingIterator() {
        return new DecItr();
    }

    private class DecItr implements Iterator<E> {
        ListItr itr = new ListItr(size());

        @Override
        public boolean hasNext() {
            return itr.hasPrevious();
        }

        @Override
        public E next() {
            return itr.previous();
        }

        @Override
        public void remove() {
            itr.remove();
        }
    }

    //TODO: all that

    public Object clone() {
        //TODO: clone
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
        return new SubList<E>(fromIndex, toIndex);
    }

    //TODO: sublist class
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

    //TODO: spliterator
    public Spliterator<E> spliterator() {
        return new SplitItr();
    }

    private class SplitItr implements Spliterator<E> {


        @Override
        public boolean tryAdvance(Consumer<? super E> action) {
            return false;
        }

        @Override
        public Spliterator<E> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}


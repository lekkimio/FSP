package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> list1 = new MyArrayList<>();
        MyArrayList<String> list2 = new MyArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(list1.containsAll(list2));

       /* System.out.println("----------------------------------------");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyLinkedList<String> linkedList1  = new MyLinkedList<>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList1.add("a");
        linkedList1.add("b");
        linkedList1.add("c");

        System.out.println(linkedList);
        System.out.println(linkedList1);
        linkedList.addAll(2,linkedList1);
        System.out.println(linkedList);
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(linkedList);
        linkedList.removeAll(linkedList1);
        System.out.println(linkedList);*/

        /*System.out.println("----------------------------------------");
        MyLinkedList<Integer> mylist = new MyLinkedList<>();
        mylist.add(1);
        mylist.add(3);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(3);
        mylist.add(5);
        System.out.println(mylist.getFirst());
        System.out.println(mylist.getLast());
        System.out.println(mylist);

        mylist.removeFirstOccurrence(3);
        mylist.removeLastOccurrence(3);
        System.out.println(mylist);

        mylist.offer(9);
        mylist.offerFirst(0);
        mylist.offerLast(8);
        System.out.println(mylist);

        System.out.println(mylist.peek());
        System.out.println(mylist.peekFirst());
        System.out.println(mylist.peekLast());

        mylist.poll();
        mylist.pollFirst();
        mylist.pollLast();
        System.out.println(mylist);

        System.out.println();
        mylist.pop();
        mylist.push(5);
        System.out.println(mylist);

        System.out.println();
        System.out.println(mylist.element());
        System.out.println(mylist);*/

        /*System.out.println("----------------------------------------");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyLinkedList<String> linkedList1  = new MyLinkedList<>();


        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add("5");
        linkedList.add(null);

        System.out.println(linkedList);
        linkedList.addAll(2,linkedList1);


        System.out.println(linkedList.lastIndexOf(null));
        System.out.println(linkedList);
*/

        /*System.out.println("----------------------------------------");
        MyLinkedList<Integer> kek = new MyLinkedList<>();

        kek.add(1);
        kek.add(2);
        kek.add(3);

        System.out.println(kek.size());
        System.out.println(kek);

        kek.add(2, 4);

        System.out.println(kek.size());
        System.out.println(kek);

        System.out.println(kek.get(3));
        System.out.println(kek.size());
        System.out.println(kek);
        System.out.println(kek.isEmpty());
        System.out.println(kek.contains(5));

        kek.add(2);
        kek.add(3);
        System.out.println(kek);
        System.out.println(kek.set(1, 6));
        System.out.println(kek);
        System.out.println(Arrays.toString(kek.toArray()));
        System.out.println(kek.indexOf(2));
        System.out.println(kek.lastIndexOf(2) + "'asd");


        System.out.println(kek+ " ---");
        System.out.println("----------------------------------------");
        MyArrayList<String> mylist1 = new MyArrayList<>();
        System.out.println(mylist1 + " " + mylist1.size());
        mylist1.add("1");
        mylist1.add("2");
        mylist1.add("3");
        mylist1.add("4");
        mylist1.add("5");
        mylist1.add("6");
        System.out.println(mylist1 + " size: " + mylist1.size());

        MyArrayList<String> mylist2 = new MyArrayList<>(10);
        mylist2.add("3");
        mylist2.add("4");
        mylist2.add("6");
        System.out.println(mylist2 + " size: " + mylist2.size());
        System.out.println(mylist1.containsAll(mylist2));*/
    }
}

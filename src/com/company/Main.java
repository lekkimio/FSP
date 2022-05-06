package com.company;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> mylist = new MyLinkedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        System.out.println(mylist.size());
        System.out.println(mylist);
        mylist.add(2, 4);
        System.out.println(mylist.size());
        System.out.println(mylist);
        System.out.println(mylist.get(3));
        mylist.removeFirst();
        mylist.removeLast();
        System.out.println(mylist.size());
        System.out.println(mylist);

    }
}

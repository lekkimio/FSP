package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

       /* MyLinkedList<Integer> mylist = new MyLinkedList<>();

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
        System.out.println(mylist.isEmpty());
        System.out.println(mylist.contains(5));

        mylist.add(2);
        mylist.add(3);
        System.out.println(mylist);
        System.out.println(mylist.set(1, 6));
        System.out.println(mylist);
        System.out.println(Arrays.toString(mylist.toArray()));
        System.out.println(mylist.indexOf(2));
        System.out.println(mylist.lastIndexOf(2));

        Integer[] a = new Integer[mylist.size()+2];
        a = mylist.toArray(a);

        // Display the contents of the array
        System.out.println("Printing elements of a:");
        for (Integer ae : a) {
            System.out.println(ae);
        }
        System.out.println(mylist+ " ---");
        System.out.println(mylist.getFirst()+ " ---");
        System.out.println(mylist.getLast() + " ---");*/

        MyArrayList<String> mylist2 = new MyArrayList<>(3);

        mylist2.add("a");
        mylist2.add("r");
        mylist2.add("c");
        mylist2.add("d");
        mylist2.add("r");
        mylist2.add("t");
        mylist2.add("y");
        mylist2.add("u");
        mylist2.add("i");
        mylist2.add("k");
        System.out.println(mylist2 + " " + mylist2.size());
        System.out.println(mylist2.indexOf("r"));
        System.out.println(mylist2.lastIndexOf("r"));
        System.out.println(mylist2 + " " + mylist2.size());
        System.out.println(mylist2.contains("U"));
        System.out.println(mylist2.contains("u"));


    }
}

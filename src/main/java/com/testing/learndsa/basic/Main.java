package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(-1));
        System.out.println(linkedList.get(3));

        linkedList.printList();
    }
}

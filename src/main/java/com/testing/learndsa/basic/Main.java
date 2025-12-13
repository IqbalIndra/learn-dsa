package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.append(5);
        linkedList.append(5);
        System.out.println("------");
        linkedList.printList();
        System.out.println("------");
        linkedList.removeDuplicate();
        System.out.println("After Remove ------");
        linkedList.printList();
    }
}

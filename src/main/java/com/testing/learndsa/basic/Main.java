package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(3);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);
        System.out.println("------");
        linkedList.printList();
        linkedList.partitionList(5);
        System.out.println("---After Partition ----");
        linkedList.printList();
        System.out.println("------");
    }
}

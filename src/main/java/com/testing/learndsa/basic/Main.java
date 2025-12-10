package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);

        System.out.println(linkedList.insert(1 , 4));
        System.out.println(linkedList.insert(0, 5));
        System.out.println(linkedList.insert(4, 6));
        System.out.println(linkedList.insert(1, 7));
        System.out.println(linkedList.insert(6, 8));
        System.out.println(linkedList.insert(7, 9));
        System.out.println(linkedList.insert(0, 10));

        linkedList.printList();
    }
}

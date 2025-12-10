package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        System.out.println(linkedList.set(2 , 4));
        System.out.println(linkedList.set(0, 5));
        System.out.println(linkedList.set(-1 , 6));
        System.out.println(linkedList.set(3 , 7));

        linkedList.printList();
    }
}

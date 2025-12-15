package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.append(9);
        linkedList1.append(0);
        LinkedList.Node node1 = linkedList1.getHead();
        linkedList1.clearAll();
        linkedList1.append(9);
        linkedList1.append(9);
        LinkedList.Node node2 = linkedList1.getHead();
        LinkedList.Node node = linkedList1.addSum(node1, node2);

        while(node != null){
            System.out.print(node.value);
            if(node.next != null){
                System.out.print("->");
            }
            node = node.next;
        }

    }
}

package com.testing.learndsa.basic;

import java.util.HashSet;
import java.util.Set;

public class BrowserHistory {
    private Node visited;

    class Node{
        String url;
        Node prev;
        Node next;

        public Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }
    public BrowserHistory(String homepage) {
        visited = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        visited.next = node;
        node.prev = visited;
        visited = node;
    }

    public String back(int steps) {
        while(visited.prev != null && steps > 0){
            visited = visited.prev;
            steps--;
        }
        return visited.url;
    }

    public String forward(int steps) {
        while(visited.next != null && steps > 0){
            visited = visited.next;
            steps--;
        }
        return visited.url;
    }
}

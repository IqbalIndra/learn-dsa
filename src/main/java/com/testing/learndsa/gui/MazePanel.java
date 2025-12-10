package com.testing.learndsa.gui;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;

class Node {
    String name;
    int x, y;
    String[] links;
    double distance = Double.MAX_VALUE; // For Dijkstra's algorithm
    Node previous = null; // For reconstructing the path

    Node(String name, int x, int y, String[] links) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.links = links;
    }
}

public class MazePanel extends JPanel {

    private final Map<String, Node> nodes = new HashMap<>();
    private final int numColumns, numRows;
    private List<Node> shortestPath;
    private Timer timer;
    private int animationStep;

    public MazePanel(String[] nodeData) {
        String[] firstLine = nodeData[0].split(",");
        numColumns = Integer.parseInt(firstLine[1]);
        numRows = Integer.parseInt(firstLine[2]);

        for (int i = 1; i < nodeData.length; i++) {
            String[] parts = nodeData[i].split(",");
            String name = parts[0];
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            String[] links = {parts[3], parts[4]};
            nodes.put(name, new Node(name, x, y, links));
        }

        findShortestPath();
        animatePath();
    }

    private void findShortestPath() {
        Node startNode = nodes.get("START");
        Node exitNode = nodes.get("EXIT");

        startNode.distance = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.distance));
        pq.add(startNode);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current == exitNode) break;

            for (String link : current.links) {
                if (!link.equals("A")) {
                    Node neighbor = nodes.get(link.equals("W") ? "EXIT" : link);
                    double newDist = current.distance + 1; // Assuming all edges have the same weight
                    if (newDist < neighbor.distance) {
                        neighbor.distance = newDist;
                        neighbor.previous = current;
                        pq.add(neighbor);
                    }
                }
            }
        }

        // Reconstruct the path
        shortestPath = new ArrayList<>();
        for (Node at = exitNode; at != null; at = at.previous) {
            shortestPath.add(at);
        }
        Collections.reverse(shortestPath);
    }

    private void animatePath() {
        animationStep = 0;
        timer = new Timer(300, e -> {
            if (animationStep < shortestPath.size()) {
                repaint();
                animationStep++;
            } else {
                timer.stop();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int cellWidth = getWidth() / (numColumns + 1);
        int cellHeight = getHeight() / (numRows + 1);

        // Draw edges
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.GREEN);
        for (Node node : nodes.values()) {
            int x1 = node.x * cellWidth;
            int y1 = node.y * cellHeight;
            for (String link : node.links) {
                if (!link.equals("A")) {
                    Node linkedNode = nodes.get(link.equals("W") ? "EXIT" : link);
                    int x2 = linkedNode.x * cellWidth;
                    int y2 = linkedNode.y * cellHeight;
                    g2.drawLine(x1, y1, x2, y2);
                }
            }
        }

        // Draw nodes
        g2.setColor(Color.BLUE);
        for (Node node : nodes.values()) {
            int x = node.x * cellWidth - 10;
            int y = node.y * cellHeight - 10;
            g2.fillOval(x, y, 20, 20);
        }

        // Highlight the start and exit nodes
        g2.setColor(Color.RED);
        Node startNode = nodes.get("START");
        g2.fillOval(startNode.x * cellWidth - 10 , startNode.y * cellHeight - 10, 20, 20);

        Node exitNode = nodes.get("EXIT");
        g2.fillOval(exitNode.x * cellWidth - 10, exitNode.y * cellHeight - 10, 20, 20);

        // Draw labels
        g2.setColor(Color.BLACK);
        for (Node node : nodes.values()) {
            int x = node.x * cellWidth - 10;
            int y = node.y * cellHeight - 15;
            g2.drawString(node.name, x, y);
        }

        // Animate the shortest path
        /*if (shortestPath != null && animationStep > 0) {
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(3));
            for (int i = 0; i < animationStep - 1; i++) {
                Node n1 = shortestPath.get(i);
                Node n2 = shortestPath.get(i + 1);
                int x1 = n1.x * cellWidth;
                int y1 = n1.y * cellHeight;
                int x2 = n2.x * cellWidth;
                int y2 = n2.y * cellHeight;
                g2.drawLine(x1, y1, x2, y2);
            }
        }*/
    }

    public static void main(String[] args) {
        String[] nodeData = {
                "22,7,6",
                "START,0,2,B,A",
                "B,1,2,C,K",
                "C,1,3,D,E",
                "D,1,4,A,A",
                "E,2,3,F,J",
                "F,2,4,G,H",
                "G,2,5,A,A",
                "H,3,4,A,I",
                "I,4,4,A,A",
                "J,2,2,A,A",
                "K,1,1,L,A",
                "L,2,1,N,M",
                "M,2,0,A,A",
                "N,3,1,O,A",
                "O,3,2,A,P",
                "P,4,2,Q,V",
                "Q,4,3,R,S",
                "R,3,3,A,A",
                "S,5,3,T,U",
                "T,5,4,A,A",
                "U,5,2,W,A",
                "V,4,1,A,A",
                "EXIT,6,2,A,A"
        };

        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(new MazePanel(nodeData));
        frame.setVisible(true);
    }
}



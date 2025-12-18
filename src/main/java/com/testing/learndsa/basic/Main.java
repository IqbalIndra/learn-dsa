package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("esgriv.com");
        browserHistory.visit("cgrt.com");
        browserHistory.visit("tip.com");
        System.out.println(browserHistory.back(9));
        browserHistory.visit("kttzxgh.com");
        System.out.println(browserHistory.forward(7));

    }
}

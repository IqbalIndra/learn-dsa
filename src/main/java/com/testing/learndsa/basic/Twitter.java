package com.testing.learndsa.basic;

import java.util.*;
import java.util.stream.Collectors;

class Twitter {
    private static int timestamp = 0;
    private Map<Integer,User> userMap;

    class Tweet {
        int id;
        int time;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    class User {
        public int id;
        public Set<Integer> followed;
        public List<Tweet> tweets;

        public User(int id){
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            this.tweets = new ArrayList<>();
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId);
            tweets.add(0,tweet);
        }

    }

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId , new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        if(!userMap.containsKey(userId)) return news;

        Set<Integer> followed = userMap.get(userId).followed;
        Queue<Tweet> tweets = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.time,o1.time));

        for(Integer followee : followed){
            List<Tweet> tweetUsers = userMap.get(followee).tweets;
            tweets.addAll(tweetUsers);
        }

        int size = 10;
        while(!tweets.isEmpty() && size > 0){
            news.add(tweets.poll().id);
            size--;
        }

        return news;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;

        userMap.putIfAbsent(followerId , new User(followerId));
        userMap.putIfAbsent(followeeId , new User(followeeId));

        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/6/14.
 */
public class leetcode355 {
    class Twitter {

        class Message{
            public Message(Integer userId, Integer tweetId){
                this.tweetId = tweetId;
                this.userId = userId;
            }

            public Integer userId;
            public Integer tweetId;
            public Message next;

        }

        Message head = null;
        Map<Integer, Set<Integer>> follow = new HashMap<>();
        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Message newMsg = new Message(userId, tweetId);
            newMsg.next = head;
            head = newMsg;
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> newsFeed = new ArrayList<>();
            Message h = head;
            Set<Integer> followSet = follow.get(userId);
            while ((h!=null) && (newsFeed.size()<10)){
                if ((userId == h.userId)||((followSet !=null) && (followSet.contains(h.userId)))){
                    newsFeed.add(h.tweetId);
                }
                h = h.next;
            }
            return newsFeed;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followSet = follow.get(followerId);
            if (followSet == null){
                followSet = new HashSet<>();
                followSet.add(followeeId);
                follow.put(followerId, followSet);
            } else {
                followSet.add(followeeId);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followSet = follow.get(followerId);
            if (followSet != null) {
                followSet.remove(followeeId);
            }
        }
    }

}

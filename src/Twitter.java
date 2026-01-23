import java.util.*;

class Twitter {
    HashMap<Integer,TreeMap<Integer,Integer>> postsMap;
    HashMap<Integer,TreeSet<Integer>> followMap;
    int count=0;
    public Twitter() {
        postsMap = new HashMap<>();
        followMap= new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        postsMap.putIfAbsent(userId,new TreeMap<>());
        postsMap.get(userId).put(count++,tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        followMap.putIfAbsent(userId,new TreeSet<>());
        followMap.get(userId).add(userId);
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        TreeSet<Integer> followees= followMap.get(userId);
        if(followees!=null){
            for (Integer followee : followees) {
                TreeMap<Integer,Integer> posts= postsMap.get(followee);
                if(posts!=null){
                    for (Map.Entry<Integer, Integer> entry : posts.entrySet()) {

                            minHeap.offer(new int[]{entry.getKey(),entry.getValue()});
                            if(minHeap.size()>10){
                                minHeap.poll();
                            }

                    }

                }
            }
        }
        List<Integer> ans= new ArrayList<>();
        for (int i = 0; i < minHeap.size(); i++) {
            ans.add(0);
        }
        int count=minHeap.size()-1;
        while (!minHeap.isEmpty()){
            ans.set(count--,minHeap.poll()[1]);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new TreeSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // Posting tweets by user 1
        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 4);
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 6);
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 11);

        // ["getNewsFeed", [1]]
        System.out.println(twitter.getNewsFeed(1));
        // Expected: [11, 10, 9, 8, 7, 6, 5, 4, 3, 2]

        // ["follow", [2, 1]]
        twitter.follow(2, 1);

        // ["getNewsFeed", [2]]
        System.out.println(twitter.getNewsFeed(2));
        // Expected: [11, 10, 9, 8, 7, 6, 5, 4, 3, 2]

        // ["unfollow", [2, 1]]
        twitter.unfollow(2, 1);

        // ["getNewsFeed", [2]]
        System.out.println(twitter.getNewsFeed(2));
        // Expected: []
    }


}

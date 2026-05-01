class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> userTweets;

    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new LinkedList<>());
        }
        // Add newest tweets to the front of the list for easier access
        userTweets.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        if (userTweets.containsKey(userId)) {
            addLimitedTweets(pq, userTweets.get(userId));
        }

        // Add tweets from followees
        Set<Integer> followedUsers = following.get(userId);
        if (followedUsers != null) {
            for (int followeeId : followedUsers) {
                if (userTweets.containsKey(followeeId)) {
                    addLimitedTweets(pq, userTweets.get(followeeId));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
    
    // Helper to only add the 10 most recent from a specific user to the PQ
    private void addLimitedTweets(PriorityQueue<Tweet> pq, List<Tweet> tweets) {
        int count = 0;
        for (Tweet t : tweets) {
            if (count >= 10) break;
            pq.add(t);
            count++;
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
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
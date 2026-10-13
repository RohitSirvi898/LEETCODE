class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        int step = 1;

        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){

                String curr = que.poll();
                
                if(curr.equals(endWord)) return step;
                
                char[] arr = curr.toCharArray();

                for(int j=0;j<arr.length;j++){
                    char original = arr[j];
                    for(char ch = 'a';ch <= 'z';ch++){
                        arr[j] = ch;
                        String str = new String(arr);
                        if(set.contains(str)){
                            que.offer(str);
                            set.remove(str);
                        }
                    }
                    arr[j] = original;
                }
            }
            step++;
        }
        return 0;

    }
}
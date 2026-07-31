class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i:word.toCharArray()){
            freq[i-'a']++;
        }

        Arrays.sort(freq);

        int count=0;
        int times=1;
        int sum = 0;

        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            sum+=freq[i]*times;
            count++;
            if(count==8){
                times++;
                count=0;
            }
        }
        return sum;
    }
}
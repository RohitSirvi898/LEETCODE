class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                freq[i]--;
                int required = 0;
                boolean found = true;
                for(int j=0;j<26;j++){
                    if(freq[j]==0) continue;
                    if(required==0){
                        required = freq[j];
                    }
                    else if(required!=freq[j]){
                        found = false;
                        break;
                    }
                }
                if(found){
                    return true;
                }
                freq[i]++;
            }
        }
        return false;
    }
}
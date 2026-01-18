class Solution {
    public int vowelConsonantScore(String s) {
        int v=0;
        int c=0;
        int score =0;
        
        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') v++;
            else if(ch-'a'>=0 && ch-'z'<=0) c++;
        }
        if(c>0){
            score=(int)Math.floor(v/c);
        }
        return score;
    }
}
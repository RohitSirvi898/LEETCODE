class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int i = 0;
        int j = n-1;
        int score = 0;
        int max = 0;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                score++;
                max = Math.max(score,max);
                i++;
            }
            else if(score>0 && power<tokens[j]){
                power+=tokens[j];
                score--;
                j--;
            }
            else break;
        }
        return max;
    }
}
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();

        for(String word:words){
            int sum = 0;
            for(int i=0;i<word.length();i++){
                sum+=weights[word.charAt(i)-'a'];
            }
            sum%=26;
            str.append((char)('z'-sum));
        }
        return str.toString();
    }
}
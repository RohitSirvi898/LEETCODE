class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int[] charArray = new int[58];
        for(char ch : t.toCharArray()){
            charArray[ch-'A']++;
        }

        int startIndex = 0;
        int minIndex = 0;
        int maxIndex = Integer.MAX_VALUE;
        int targetLength = t.length();

        for(int endIndex = 0; endIndex<s.length(); endIndex++){
            char endChar = s.charAt(endIndex);
            if(charArray[endChar-'A']>0){
                targetLength--;
            }
            charArray[endChar-'A']--;
            if(targetLength==0){
                while(true){
                    char startChar = s.charAt(startIndex);
                    if(charArray[startChar-'A']==0) break;
                    charArray[startChar-'A']++;
                    startIndex++;
                }

                if(endIndex-startIndex<maxIndex-minIndex){
                    minIndex = startIndex;
                    maxIndex = endIndex;
                }
                charArray[s.charAt(startIndex)-'A']++;
                targetLength++;
                startIndex++;
            }
        }
        return maxIndex==Integer.MAX_VALUE? "" : s.substring(minIndex,maxIndex+1);
    }
}
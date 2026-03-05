class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean arr[] = new boolean[26];
        int count=0;
        for(char ch : sentence.toCharArray()){
            if(arr[ch-'a']==false) count++;
            arr[ch-'a']=true;
        }
        return count==26;
    }
}
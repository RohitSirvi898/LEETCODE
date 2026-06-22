class Solution {
    public int maxNumberOfBalloons(String text) {
        int arr[] = new int[26];
        for(int i=0;i<text.length();i++){
            arr[text.charAt(i)-'a']++;
        }
        arr['l'-'a']/=2;
        arr['o'-'a']/=2;
        int count = Integer.MAX_VALUE;
        count = Math.min(arr['b'-'a'],count);
        count = Math.min(arr['a'-'a'],count);
        count = Math.min(arr['l'-'a'],count);
        count = Math.min(arr['o'-'a'],count);
        count = Math.min(arr['n'-'a'],count);
        return count;
    }
}
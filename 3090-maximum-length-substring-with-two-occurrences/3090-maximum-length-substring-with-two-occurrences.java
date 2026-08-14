class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>2){
                char ch = s.charAt(j);
                map.put(ch,map.get(ch)-1);
                j++;
            }
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
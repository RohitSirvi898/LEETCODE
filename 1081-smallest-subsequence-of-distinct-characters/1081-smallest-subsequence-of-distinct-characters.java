class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            int c = ch-'a';
            freq[c]--;
            if(seen[c]) continue;
            while(!st.isEmpty() && (st.peek()>ch && freq[st.peek()-'a']!=0)){
                seen[st.pop()-'a'] = false;
            }
            st.push(ch);
            seen[c] = true;
        }

        StringBuilder ans = new StringBuilder();
        for(char ch:st){
            ans.append(ch);
        }

        return ans.toString();
    }
}
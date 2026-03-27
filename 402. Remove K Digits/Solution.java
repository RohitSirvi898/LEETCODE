class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char digit:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        while(str.length()>0 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
        }
        return str.length()>0?str.toString():"0";
    }
}
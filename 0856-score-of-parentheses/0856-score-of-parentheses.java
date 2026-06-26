class Solution {
    public int scoreOfParentheses(String s) {
        Stack<int[]> st = new Stack<>();
        int depth = 0; 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') depth++;
            else{
                int score = 1;
                if(!st.isEmpty() && st.peek()[0]==depth){
                    while(!st.isEmpty() && st.peek()[0]==depth){
                        score+=st.pop()[1];
                    }
                    st.push(new int[]{depth,score});
                }
                else if(!st.isEmpty() && st.peek()[0]==depth+1){
                    score = 2*st.pop()[1];
                    while(!st.isEmpty() && st.peek()[0]==depth){
                        score+=st.pop()[1];
                    }
                    st.push(new int[]{depth,score});
                }
                else {
                    st.push(new int[]{depth,score});
                    
                }
                depth--;
            }
        }

        return st.peek()[1];

    }
}
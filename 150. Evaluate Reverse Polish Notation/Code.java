class Solution {

    public boolean isOperator(String op){
        if(op.equals("+")|| op.equals("-") || op.equals("*") || op.equals("/")) return true;
        return false;
    } 

    public int Operation(int a,int b, String op){
        if(op.equals("+")){
            return a+b;
        }
        else if(op.equals("-")){
            return a-b;
        }
        else if(op.equals("*")){
            return a*b;
        }
        else if(op.equals("/")){
            return a/b;
        }
        else{
            return -1;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        // int ans=0;
        for(String s: tokens){
            if(isOperator(s)){
                int b= st.pop();
                int a= st.pop();
                st.push(Operation(a,b,s));
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
class Solution {

    public int area(int[] dp){
        Stack<Integer> st = new Stack<>();
        int max=0;
        int n=dp.length;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || dp[i]<=dp[st.peek()])){
                int h = dp[st.peek()];
                st.pop();
                int w = 0;
                if(st.isEmpty()){
                    w = i;
                }
                else{
                    w = i-st.peek()-1;
                }
                max = Math.max(max,h*w);
            }
            st.push(i);
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[j] = dp[j] + (matrix[i][j] - '0');
                }
                else{
                    dp[j] = 0;
                }
            }
            ans = Math.max(ans,area(dp));
        }
        return ans;
    }
}
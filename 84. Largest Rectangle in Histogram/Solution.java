class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[i]<=heights[st.peek()])){
                int h=heights[st.peek()];
                st.pop();
                int w=0;
                if(st.isEmpty()) w=i;
                else w=i-st.peek()-1;
                max=Math.max(max,w*h);
            }
            st.push(i);
        }
        return max;
    }
}
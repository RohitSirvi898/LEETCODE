class Solution {

    public void helper(int[][] image, int sr, int sc, int color, int target){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=target || image[sr][sc]==color) return;
        image[sr][sc] = color;
        helper(image,sr+1,sc,color,target);
        helper(image,sr,sc+1,color,target);
        helper(image,sr-1,sc,color,target);
        helper(image,sr,sc-1,color,target);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        helper(image,sr,sc,color,target);
        return image;
    }
}
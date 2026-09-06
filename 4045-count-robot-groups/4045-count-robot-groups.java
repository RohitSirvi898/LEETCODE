class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;

        int groups = 0;
        int currentTopSpeed = Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--){
            boolean isRightmost = (i==n-1) || (position[i+1]-position[i]>distance);
            if(isRightmost && speed[i]<=currentTopSpeed){
                groups++;
                currentTopSpeed = speed[i];
            }
        }

        return groups;
    }
}
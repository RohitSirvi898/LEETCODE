class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] seen = new int[1001];
        for(int i:nums1){
            seen[i]++;
        }

        int[] temp = new int[1001];
        int idx = 0;
        for(int i:nums2){
            if(seen[i]>0){
                temp[idx++]=i;
                seen[i]--;
            }
        }
        return Arrays.copyOf(temp,idx);
    }
}
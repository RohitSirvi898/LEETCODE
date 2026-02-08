public class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n=nums.length;
        List<Long> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add((long)nums[i]);
        }
        int i=0;
        while(i<ans.size()){
            if(i!=0 && ans.get(i).equals(ans.get(i-1))){
                ans.remove(i);
                i--;
                ans.set(i,ans.get(i)*2);
            }
            else if(i!=ans.size()-1 && ans.get(i).equals(ans.get(i+1))){
                ans.remove(i+1);
                ans.set(i,ans.get(i)*2);
            }
            else i++;
        }
        return ans;
    }
} {
    
}

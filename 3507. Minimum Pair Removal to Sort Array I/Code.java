class Solution {
    public boolean isSorted(List<Integer> arr){
        int n=arr.size();
        for(int i=0;i<n-1;i++){
            if(arr.get(i)>arr.get(i+1)) return false;
        }
        return true;
    }

    public int minPair(List<Integer> arr){
        int pos=0;
        int min=Integer.MAX_VALUE;
        int n=arr.size();
        for(int i=0;i<n-1;i++){
            int sum = arr.get(i)+arr.get(i+1);
            if(sum<min){
                min=sum;
                pos=i;
            }
        }
        return pos;
    }

    public void mergePair(List<Integer> arr,int pos){
        arr.set(pos,arr.get(pos)+arr.get(pos+1));
        arr.remove(pos+1);
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            arr.add(nums[i]);
        }
        int ans = 0;
        while(!isSorted(arr)){
            int pos = minPair(arr);
            mergePair(arr,pos);
            ans++;
        }
        return ans;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int h=0;
        for(int i:weights) {
            h+=i;
            l=Math.max(i,l);
        }

        while(l<h){
            int m=l+(h-l)/2;
            int count=1;
            int weight=0;
            for(int item:weights){
                if(weight+item>m){
                    count++;
                    weight=item;
                }
                else{
                    weight+=item;
                }
            }
            if(count<=days) h=m;
            else l=m+1;
        }
        return l;
    }
}
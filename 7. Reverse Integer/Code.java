class Solution {
    public int reverse(int x) {
        int i=0;
        while(x!=0){
            int a= x%10;
            if(i>Integer.MAX_VALUE/10 || (i==Integer.MAX_VALUE/10 && a>7)) return 0;
            if(i<Integer.MIN_VALUE/10 || (i==Integer.MIN_VALUE/10 && a<-8)) return 0;
            i=i*10+a;
            x=x/10;
        }
        return i;
    }
}
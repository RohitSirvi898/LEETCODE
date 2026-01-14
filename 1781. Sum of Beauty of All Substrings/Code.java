class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            char[] arr=new char[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for(int num:arr){
                    if(num!=0) min=Math.min(min,num);
                    max=Math.max(max,num);
                }
                if(min!=Integer.MAX_VALUE)count+=(max-min);
            }
        }
        return count;
    }
}
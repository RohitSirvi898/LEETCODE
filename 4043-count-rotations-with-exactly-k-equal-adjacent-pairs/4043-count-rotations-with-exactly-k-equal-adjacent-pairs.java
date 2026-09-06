class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int totalcircularpair = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)==s.charAt((i+1)%n)) totalcircularpair++;
        }

        int count = 0;

        for(int i=0;i<n;i++){
            int brokenpair = 0;

            int left = (i-1+n)%n;
            int right = i;

            if(s.charAt(left)==s.charAt(right)) brokenpair = 1;

            int score = totalcircularpair-brokenpair;
            if(score==k) count++;
        }

        return count;
    }
}
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i=0,j=n-1;
        int boat = 0;
        for(;i<=j;j--){
            if(people[i]+people[j]<=limit){
                i++;
            }
            boat++;
        }
        return boat;

    }
}
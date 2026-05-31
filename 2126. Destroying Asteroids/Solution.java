class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long planet = mass;
        Arrays.sort(asteroids);
        for(int i:asteroids){
            if(planet>=i) planet+=i;
            else return false;
        }
        return true;
    }
}
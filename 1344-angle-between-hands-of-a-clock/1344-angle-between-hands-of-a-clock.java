class Solution {
    public double angleClock(int hour, int minutes) {
        Double angle = Math.abs(hour*30 - minutes*5.5);
        return Math.min(360-angle,angle);
    }
}
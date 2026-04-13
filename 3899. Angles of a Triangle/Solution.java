class Solution {
    public double[] internalAngles(int[] sides) {
        double a = sides[0], b = sides[1], c = sides[2];
        if(a+b<=c || b+c<=a || a+c<=b) return new double[]{};

        double[] res = new double[3];
        double angle_a = Math.acos((b*b + c*c - a*a)/(2*b*c));
        double angle_b = Math.acos((a*a + c*c - b*b)/(2*a*c));
        double angle_c = Math.acos((b*b + a*a - c*c)/(2*b*a));

        res[0] = Math.toDegrees(angle_a);
        res[1] = Math.toDegrees(angle_b);
        res[2] = Math.toDegrees(angle_c);
        Arrays.sort(res);
        return res;
    }
}
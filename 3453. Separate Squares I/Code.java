class Solution {
    public double findArea(int[][] squares,double h){
        double totalarea=0;
        for(int[] square:squares){
            double y=square[1];
            double l=square[2];
            double top=y+l;
            
            if(y>=h) continue;
            double effectiveheight=Math.min(top,h)-y;
            totalarea+=effectiveheight*l;
        }
        return totalarea;
    }

    public double separateSquares(int[][] squares) {
        double max=0;
        double min=squares[0][1];
        double totalarea=0;
        for(int[] square:squares){
            totalarea+=(double)square[2]*square[2];
            max=Math.max(max,square[1]+square[2]);
            min=Math.min(min,square[1]);
        }

        double target=totalarea/2.0;

        double h=max;
        double l=min;
        for(int i=0;i<100;i++){
            double m=l+(h-l)/2; 
            double belowArea=findArea(squares,m);
            if(target>belowArea) l=m;
            else h=m;
        }
        return l;
    }
}
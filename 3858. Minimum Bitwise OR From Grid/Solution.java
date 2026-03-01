class Solution {
    public int minimumOR(int[][] grid) {
        int [][] tavol = grid;
        int mask = 0;
        for(int bit = 30; bit >= 0; bit--){
            int candidate = mask | (1<<bit);
            boolean pforAll = true;

            for(int i = 0;i<tavol.length;i++){
                boolean pforthis = false;

                for(int j=0;j<tavol[i].length;j++){
                    if((tavol[i][j] & candidate)==0){
                        pforthis = true;
                        break;
                    }
                }
                if(!pforthis){
                    pforAll = false;
                    break;
                }
            }
            if(pforAll) mask = candidate;
        }
        return Integer.MAX_VALUE^mask;
    }
}
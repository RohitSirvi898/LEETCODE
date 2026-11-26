class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = false;
        for(int i=10;i>=0;i--){
            if(n<i) return alice;
            n-=i;
            alice = !alice;
        }
        return alice;
    }
}
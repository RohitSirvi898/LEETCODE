class Solution {
    public StringBuilder invert (StringBuilder str){
        StringBuilder inverted = new StringBuilder(str);
        for(int i=0;i<inverted.length();i++){
            if(inverted.charAt(i)=='1') inverted.setCharAt(i,'0');
            else inverted.setCharAt(i,'1');
        }
        return inverted;
    }

    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder inverted = invert(str);
            str.append("1");
            str.append(inverted.reverse());
        }
        System.out.println(str);
        return str.charAt(k-1);
    }
}
class Solution {
    public boolean isDigitorialPermutation(int n) {

        String digitorials[] = new String[]{"1","2","145","40585"};
        char[] nchar = String.valueOf(n).toCharArray();
        Arrays.sort(nchar);
        String s = new String(nchar);

        for(String target:digitorials){
            char[] targetchar=target.toCharArray();
            Arrays.sort(targetchar);
            String targetS = new String(targetchar);
            if(s.equals(targetS)) return true;
        }
        return false;
    }
}
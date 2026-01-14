class Solution {
    
    public String frequencySort(String s) {

        Pair[] count = new Pair[100];
        for(int i=0;i<100;i++){
            count[i]=new Pair(0,(char)(i+'0'));
        }

        for(char c:s.toCharArray()){
            count[c-'0'].freq++;
        }

        Arrays.sort(count,(p1,p2)->{
            if(p1.freq!=p2.freq) return p2.freq-p1.freq;
            return p1.ch-p2.ch;
        });

        String ans="";
        for(Pair elem:count){
            if(elem.freq>0) {
                for(int i=0;i<elem.freq;i++)ans+=elem.ch;
            }
        }

        return ans;
    }
}
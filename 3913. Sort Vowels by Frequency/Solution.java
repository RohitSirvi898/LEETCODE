class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[26];
        int[] firstoccur = new int[26];
        Arrays.fill(firstoccur,-1);

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                freq[c-'a']++;
                if(firstoccur[c-'a']==-1) firstoccur[c-'a']=i;
            }
        }

        List<Character> sortedVowel = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isVowel(c)) sortedVowel.add(c);
        }

        sortedVowel.sort((a,b)->{
            if(freq[a-'a']!=freq[b-'a']){
                return Integer.compare(freq[b-'a'],freq[a-'a']);
            }
            return Integer.compare(firstoccur[a-'a'],firstoccur[b-'a']);
        });

        char[] result = s.toCharArray();
        int index = 0;
        for(int i=0;i<result.length;i++){
            if(isVowel(result[i])){
                result[i]=sortedVowel.get(index++);
            }
        }
        return new String(result);
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
}
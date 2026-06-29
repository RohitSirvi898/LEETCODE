class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        // System.out.println(map.get('4')[1]);
        StringBuilder str = new StringBuilder();
        helper(digits, map,str,0);
        return ans;
    }

    public void helper(String digits,HashMap map, StringBuilder str, int i){
        if(i==digits.length()){
            ans.add(str.toString());
            return;
        }
        char s[] = (char[])map.get(digits.charAt(i));
        
        for(int k=0;k<s.length;k++){
            str.append(s[k]);
            helper(digits, map,str,i+1);
            str.setLength(str.length()-1);
        }
    }
}
// if there is comma then they are separate words
// else concatinate them into one word.
// so approach will be:
// use set for storing unique words.
// 

class Solution {
    TreeSet<String> ans = new TreeSet<>();

    public void dfs(String s){
        int r = s.indexOf('}');
        if(r==-1){
            ans.add(s);
            return;
        }

        int l = s.lastIndexOf('{',r);
        String left = s.substring(0,l);
        String right = s.substring(r+1);

        String mid = s.substring(l+1,r);

        for(String part:mid.split(",")){
            dfs(left+part+right);
        }
    }
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(ans);
    }
}
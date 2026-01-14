class Solution {
    class Pair{
        int priority;
        String code;
        Pair(int priority,String code){
            this.priority=priority;
            this.code=code;
        }
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        HashMap<String,Integer> priority = new HashMap<>();
        priority.put("electronics",0);
        priority.put("grocery",1);
        priority.put("pharmacy",2);
        priority.put("restaurant",3);

        List<Pair> valid = new ArrayList<>();
        for(int i=0;i<code.length;i++){
            if(isActive[i] && code[i].matches("[a-zA-Z0-9_]+") && priority.containsKey(businessLine[i])){
                valid.add(new Pair(priority.get(businessLine[i]),code[i]));
            }
        }

        Collections.sort(valid,(a,b)->{
            if(a.priority!=b.priority) return a.priority-b.priority;
            return a.code.compareTo(b.code);
        });
        
        List<String> ans=new ArrayList<>();
        for(Pair s:valid){
            ans.add(s.code);
        }

        return ans;
    }
}
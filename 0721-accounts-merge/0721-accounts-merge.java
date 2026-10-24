class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    int other = map.get(email);
                    int p1 = find(parent, i);
                    int p2 = find(parent, other);

                    if (p1 != p2) {
                        parent[p1] = p2;
                    }
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> mapping = new HashMap<>();

        for (String email : map.keySet()) {
            int p = find(parent, map.get(email));

            mapping.computeIfAbsent(p, k -> new ArrayList<>())
                   .add(email);
        }

         List<List<String>> ans = new ArrayList<>();

        for (int p : mapping.keySet()) {
            List<String> ar = new ArrayList<>();
            ar.add(accounts.get(p).get(0));

            Collections.sort(mapping.get(p));
            ar.addAll(mapping.get(p));

            ans.add(ar);
        }

        return ans;
    }

    public int find(int[] parent, int x){
        if(parent[x]!=x) parent[x] = find(parent,parent[x]);
        return parent[x];
    }
}
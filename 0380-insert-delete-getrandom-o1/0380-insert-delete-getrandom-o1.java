class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> arr;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        int last = arr.size()-1;
        int temp = arr.get(last);
        map.put(temp,index);
        arr.set(index,temp);
        arr.removeLast();
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
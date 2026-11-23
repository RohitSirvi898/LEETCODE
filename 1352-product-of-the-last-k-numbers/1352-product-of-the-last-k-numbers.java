class ProductOfNumbers {
    ArrayList<Integer> list;
    int lastZero=-1;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(list.size()!=0){
            int prev = list.get(list.size()-1);
            num*=prev;
        }
        if(num==0){
            lastZero = list.size();
            num=1;
        }
        list.add(num);
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(n-k<=lastZero) return 0;
        return list.get(n-1)/list.get(n-k-1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
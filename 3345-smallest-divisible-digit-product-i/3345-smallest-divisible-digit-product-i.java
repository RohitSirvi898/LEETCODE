class Solution {
    public int smallestNumber(int n, int t) {

        for(;true;) {
            int product = digitProduct(n);

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }

    static int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product;
    }
}
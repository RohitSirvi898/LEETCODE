class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] gain = new int[n + 1];

        for (int f = 1; f <= n; f++) {
            int count = 0;
            for (int j = f; j <= n; j += f) {
                count += freq[j];
            }
            gain[f] = count-1;
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long ans = 0;
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price >= 2L*minPrice) break;
            if (gain[factor] == 0) continue;

            long count = Math.min((long) gain[factor], remaining/price);
            remaining -= count*price;
            ans += count*2;
        }

        ans += remaining/minPrice;
        return (int) ans;
    }
}
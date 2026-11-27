class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1000000000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            int value = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) value++;
            }

            for (int j = budget; j >= price; j--) {
                if (dp[j - price] != -1000000000) {
                    dp[j] = Math.max(dp[j], dp[j - price] + value);
                }
            }
        }

        int ans = 0;
        for (int spent = 0; spent <= budget; spent++) {
            if (dp[spent] != -1000000000) {
                int remaining = budget - spent;
                int extraItems = remaining / minPrice;
                ans = Math.max(ans, dp[spent] + extraItems);
            }
        }

        return ans;
    }
}
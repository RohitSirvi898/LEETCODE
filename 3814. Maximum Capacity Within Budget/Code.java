
class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        Arrays.sort(machines, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prefixMaxCap = new int[n];
        prefixMaxCap[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            prefixMaxCap[i] = Math.max(prefixMaxCap[i - 1], machines[i][1]);
        }

        int maxCap = 0;
        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                maxCap = Math.max(maxCap, machines[i][1]);
            }
        }

        for (int i = 1; i < n; i++) {
            int remainingBudget = budget - machines[i][0];
            if (remainingBudget <= machines[0][0]) continue;

            int low = 0, high = i - 1, bestIdx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (machines[mid][0] < remainingBudget) {
                    bestIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (bestIdx != -1) {
                maxCap = Math.max(maxCap, machines[i][1] + prefixMaxCap[bestIdx]);
            }
        }

        return maxCap;
    }
}
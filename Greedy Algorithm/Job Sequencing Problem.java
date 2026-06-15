import java.util.*;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {

        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        int maxDeadline = 0;

        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int countJobs = 0;
        int totalProfit = 0;

        for (int[] job : Jobs) {

            int id = job[0];
            int deadline = job[1];
            int profit = job[2];

            for (int j = deadline; j > 0; j--) {

                if (slot[j] == -1) {
                    slot[j] = id;
                    countJobs++;
                    totalProfit += profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, totalProfit};
    }
}

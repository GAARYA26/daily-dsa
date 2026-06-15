import java.util.*;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = end[i];   // end time
            meetings[i][1] = start[i]; // start time
        }

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int count = 1;
        int lastEnd = meetings[0][0];

        for (int i = 1; i < n; i++) {
            if (meetings[i][1] > lastEnd) {
                count++;
                lastEnd = meetings[i][0];
            }
        }

        return count;
    }
}

import java.util.*;

class Solution {
    public int findPlatform(int[] arr, int[] dep) {
        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;
        int maxPlatforms = 1;

        int i = 1; // arrival pointer
        int j = 0; // departure pointer

        while (i < n && j < n) {

            // arrival comes before or exactly at departure
            if (arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}

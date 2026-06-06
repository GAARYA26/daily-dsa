class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        Arrays.sort(arr, l, r + 1);
    }
}

class Solution {

    boolean solve(int idx, int target, int[] arr) {
        if(target == 0)
            return true;
        if(idx < 0)
            return false;

        boolean take = false;
        if(arr[idx] <= target)
            take = solve(idx - 1, target - arr[idx], arr);

        boolean notTake = solve(idx - 1, target, arr);

        return take || notTake;
    }

    public boolean isSubsetSum(int[] arr, int target) {
        return solve(arr.length - 1, target, arr);
    }
}

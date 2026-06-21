class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(0, candidates, target, new ArrayList<>());
        return ans;
    }

    private void solve(int idx, int[] arr, int target, List<Integer> curr) {

        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if (arr[idx] <= target) {
            curr.add(arr[idx]);
            solve(idx, arr, target - arr[idx], curr); // same index
            curr.remove(curr.size() - 1);
        }
         solve(idx + 1, arr, target, curr);
    }
}

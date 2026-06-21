class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(0, nums, new ArrayList<>());
        return ans;
    }

    private void solve(int idx, int[] nums, List<Integer> curr) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(idx + 1, nums, curr);
        curr.remove(curr.size() - 1);
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        solve(idx + 1, nums, curr);
    }
}

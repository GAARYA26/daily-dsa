class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      HashMap<Integer,Integer> map=new HashMap<>();  
      int xr=0;
      int count=0;
      map.put(0,1);
      for(int num:nums){
        xr^=num;
        int target=xr^k;
        count+=map.getOrDefault(target,0);
        map.put(xr,map.getOrDefault(xr,0)+1);

      }
        return count;

    }
}

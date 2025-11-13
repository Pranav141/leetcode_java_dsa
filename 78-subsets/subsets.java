class Solution {
    public void solve(List<List<Integer>> res, List<Integer> arr,int n,int[] nums){
        if(n == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        solve(res,arr,n+1,nums);
        arr.add(nums[n]);
        solve(res,arr,n+1,nums);
        arr.remove(arr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         solve(res,new ArrayList<>(),0,nums);
         return res;
    }
}
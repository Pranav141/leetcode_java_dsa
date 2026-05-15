class Solution {
    public void solve(List<List<Integer>> res,List<Integer> temp,int idx,int[] nums){
        if(idx == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
            temp.add(nums[idx]);
            solve(res,temp,idx+1,nums);
            temp.removeLast();
        while(idx+1<nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }        
        solve(res,temp,idx+1,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(res,new ArrayList<>(),0,nums);
        return res;
    }
}
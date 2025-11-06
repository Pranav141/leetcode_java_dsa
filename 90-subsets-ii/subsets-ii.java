class Solution {
    public void solve(int[] nums,int n,List<List<Integer>> res,List<Integer> arr){
        if(n==nums.length){
            for(int i=0;i<res.size();i++){
                if(res.get(i).equals(arr)){
                    return;
                }
            }
            res.add(new ArrayList<>(arr));
            return;
        }
        //exclude
        solve(nums,n+1,res,arr);
        
        //include
        arr.add(nums[n]);
        solve(nums,n+1,res,arr);
        arr.remove(arr.size()-1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,res,new ArrayList<>());
        return res;
    }
}
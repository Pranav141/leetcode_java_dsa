class Solution {
    public void solve(int[] arr,int n,List<Integer> temp,List<List<Integer>> res){
        if(n == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        solve(arr,n+1,temp,res);
        temp.add(arr[n]);
        solve(arr,n+1,temp,res);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        solve(nums,0,new ArrayList<>(),res);
        return res;
    }
}
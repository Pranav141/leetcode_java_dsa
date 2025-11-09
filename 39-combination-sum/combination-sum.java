class Solution {
    public void solve(List<List<Integer>> res,int[] can,int k,int idx,List<Integer> comb){
        if(k==0){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(idx<0){
            return;
        }
        solve(res,can,k,idx-1,comb);
        if(can[idx]<=k){
            comb.add(can[idx]);
            solve(res,can,k-can[idx],idx,comb);
            comb.remove(comb.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        solve(res,candidates,target,candidates.length-1,new ArrayList<>());
        return res;
    }
}
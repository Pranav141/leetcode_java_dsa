class Solution {
    public void solve(List<List<Integer>> res,List<Integer> comb,int[] arr,int target,int idx){
        if(idx==arr.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        
            if(target>=arr[idx]){
                comb.add(arr[idx]);
                solve(res,comb,arr,target-arr[idx],idx);
                comb.removeLast();
            }
                solve(res,comb,arr,target,idx+1);
            
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
}
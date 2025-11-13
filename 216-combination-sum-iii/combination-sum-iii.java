class Solution {
    public void solve(int k,int tar,List<List<Integer>> res,List<Integer> arr,int idx){
        if(arr.size() == k && tar == 0){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(arr.size() == k || tar == 0){
            return;
        }
        if(idx>9){
            return;
        }
        //exclude
        solve(k,tar,res,arr,idx+1);
        //include 
        if(idx <=tar){
            arr.add(idx);
            solve(k,tar-idx,res,arr,idx+1);
            arr.remove(arr.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k = no. of elements
        // n = target
        List<List<Integer>> res = new ArrayList<>();
        solve(k,n,res,new ArrayList<>(),1);
        return res;
    }
}
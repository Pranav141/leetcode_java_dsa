class Solution {
    public void solve(List<List<Integer>> res,List<Integer> arr,int[] nums,boolean[] visited,int idx){
        if(arr.size()==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                visited[i]=true;
                arr.add(nums[i]);
                solve(res,arr,nums,visited,idx+1);
                arr.remove(arr.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.fill(visited,false);
        solve(res,new ArrayList<>(),nums,visited,0);
        return res;
    }
}
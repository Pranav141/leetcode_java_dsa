class Solution {
    public void solve(List<List<Integer>> res,List<Integer> temp,boolean[] visited,int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i] == false){
                temp.add(nums[i]);
                visited[i]=true;
                solve(res,temp,visited,nums);
                temp.removeLast();
                visited[i]=false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(res,new ArrayList<>(),visited,nums);
        return res;
    }
}
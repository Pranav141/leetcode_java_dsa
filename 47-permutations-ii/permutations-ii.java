class Solution {
    public void solve(List<List<Integer>> res,List<Integer> arr,int[] nums
    ,boolean[] visited,HashSet<List<Integer>> st){
        if(arr.size() == nums.length){
            // for(int i=0;i<res.size();i++){
            //     if(res.get(i).equals(arr)){
            //         return;
            //     }
            // }
            st.add(new ArrayList<>(arr));
            if(st.size() == res.size()+1){
                res.add(new ArrayList<>(arr));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                visited[i]=true;
                arr.add(nums[i]);
                solve(res,arr,nums,visited,st);
                arr.remove(arr.size()-1);
                visited[i]=false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> st = new HashSet<>();
        solve(res,new ArrayList<>(),nums,visited,st);
        return res;
    }
}
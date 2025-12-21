class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1,k=nums.length-1;
            int target = -nums[i];
            while(j<k){
            List<Integer> temp = new ArrayList<>();
                if(nums[j] + nums[k] == target){
                    temp.add(nums[i]);        
                    temp.add(nums[j]);        
                    temp.add(nums[k]);
                    res.add(new ArrayList<>(temp));
                    j++;
                    // k--;  
                     while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }      
                }
                else if(nums[j] + nums[k] > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return res;
    }
}
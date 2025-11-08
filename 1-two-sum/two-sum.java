class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp=new HashMap<>();
        int i=0;
        while(i<nums.length){
            int diff=target-nums[i];
            if(mp.containsKey(diff)){
                return new int[] {mp.get(diff),i};
            }
            mp.put(nums[i], i);  
            i++;          
        }
        return new int[]{};
    }
}
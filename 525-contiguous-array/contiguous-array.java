class Solution {
    public int findMaxLength(int[] nums) {
        // [0,1,1,1,1,1,0,0,0]
        // [0,1,2,3,4,5,5,5,5]
        // [-1,0,1,2,3,4,5,4,3,2]
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0]==1?1:-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1){
                prefix[i] = prefix[i-1] + 1;
            }
            else{
                prefix[i] = prefix[i-1] - 1;
            }
        }
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(prefix[i])){
                res=Math.max(res,i-mp.get(prefix[i]));
            }
            else{
                mp.put(prefix[i],i);
            }
        }
        return res;

    }
}
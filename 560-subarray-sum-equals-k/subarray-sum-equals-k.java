class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0; 
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(mp.containsKey(sum-k)){
                int temp = mp.get(sum-k);
                res += temp;
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return res; 
    }
        // [4,1,-2,6,4,2,-1,-12,5,6,7] k = 6 k=4
        // [4,5,3,9,13,15,14,2,7,13,20] 
        /*
        4-6 = -2
        5-6 = -1
        3-6 = -3
        9-6 = 3 -> yes
        13-6 = 7
        15-6 = 9 ->yes 
        14-6 = 8
        2-6 = -4
        7-6 = 1
        13-6 = 7->yes
        20-6 = 14 -> yes

        4-4 = 0->yes
        5-5 = 1
        3-4 = -1
        9-4 = 5 -> yes
        13-4 = 9 -> yes
        15-4 = 11
        14-4 = 10
        2-4 = -2
        7-4 = 3 ->yes
        13-4 = 9 ->yes
        20 - 4 = 16  
        */
        
    
}
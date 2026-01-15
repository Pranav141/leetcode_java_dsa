class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int prev = pq.poll();
        while(!pq.isEmpty()){
            int next = pq.poll();
            res=Math.max(res,Math.abs(next-prev));
            prev = next;
        }
        return res;
    }
}
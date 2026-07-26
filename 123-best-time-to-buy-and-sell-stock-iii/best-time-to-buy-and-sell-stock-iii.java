class Solution {
    public int maxProfit(int[] prices) {
        // [3,3,5,0,0,3,1,4]
        // b1 = -3 b2 = -3
        // p = 3 b1 = -3 s1 = 0 b2 = -3 s2 = 0
        // p = 5 b1 = -3 s1 = 2 b2 = -3 s2 = 0
        // p = 0 b1 = 0 s1 = 2 b2 = 2 s2 = 2
        // p = 0 b1 = 0 s1 = 2 b2 = 2 s2 = 2
        // p = 3 b1 = 0 s1 = 3 b2 = 2 s2 = 2
        // p = 1 b1 = 0 s1 = 3 b2 = 2 s2 = 3
        // p = 4 b1 = 0 s1 = 4 b2 = 2 s2 = 6
        int b1 = -prices[0];
        int s1 = 0;
        int b2 = -prices[0];
        int s2 = 0;
        for(int i:prices){
            b1 = Math.max(b1,-i);
            s1 = Math.max(s1,b1+i);
            b2 = Math.max(b2,s1-i);
            s2 = Math.max(s2,b2+i);
        }
        return s2;
    }
}
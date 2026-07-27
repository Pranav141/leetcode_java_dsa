class Solution {
    public int solve(int[][] dp,int[] prices,int ind,int buy,int n){
        if(ind == n){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit;
        if(buy == 0){
            profit = Math.max(
                0 + solve(dp,prices,ind+1,0,n),
                -prices[ind] + solve(dp,prices,ind+1,1,n)
            );
        }
        else{
            profit = Math.max(
                0 + solve(dp,prices,ind+1,1,n),
                prices[ind] + solve(dp,prices,ind+1,0,n)
            );
        }
        dp[ind][buy] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(dp,prices,0,0,n);
    }
}
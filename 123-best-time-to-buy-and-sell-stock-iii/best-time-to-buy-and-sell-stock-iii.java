class Solution {
    public int solve(int[][][] dp,int[] prices,int ind,int tran,int buy,int n){
        if(ind == n){
            return 0;
        }
        if(dp[ind][buy][tran] != -1){
            return dp[ind][buy][tran];
        }
        if(tran == 2){
            return 0;
        }
        int profit;
        if(buy == 0){
            profit = Math.max(
                0 + solve(dp,prices,ind+1,tran,0,n),
                -prices[ind] + solve(dp,prices,ind+1,tran,1,n)
            );
        }
        else{
            profit = Math.max(
                0 + solve(dp,prices,ind+1,tran,1,n),
                prices[ind] + solve(dp,prices,ind+1,tran+1,0,n)
            );
        }
        dp[ind][buy][tran] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(dp,prices,0,0,0,n);
    }
}
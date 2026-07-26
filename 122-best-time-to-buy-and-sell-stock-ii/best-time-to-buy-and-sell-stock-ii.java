class Solution {
    public int solve(int[][] dp,int ind,int buy,int[] prices){
        if(ind == prices.length){
            return 0;
        }

        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit;
        if(buy == 0){
            profit = Math.max(
                0+solve(dp,ind+1,0,prices),
                -prices[ind] + solve(dp,ind+1,1,prices)
            );
        }
        else{
            profit = Math.max(
                0 + solve(dp,ind+1,1,prices),
                prices[ind] + solve(dp,ind + 1,0,prices)  
            );
        }
        dp[ind][buy] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        // int prev = prices[0];
        // int profit = 0;
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]>prices[i-1]){
        //         profit += prices[i]-prices[i-1];
        //     }
        // }
        // return profit;
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(dp,0,0,prices);
    }
}
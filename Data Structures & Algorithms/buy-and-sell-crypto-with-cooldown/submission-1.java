class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][prices.length+1];
        return findMaxProfit(prices, 0, -1);
    }

    int findMaxProfit(int[] prices, int idx, int buy)
    {
        if(idx >= prices.length) return 0;
        int pf = 0;
        int res = 0;
        if(buy != -1 && prices[idx] > prices[buy])
        {
           res = prices[idx]- prices[buy] + findMaxProfit(prices, idx+2, -1);
        }
        if(memo[idx][buy+1] != null) return memo[idx][buy+1];
        res = Math.max(res, Math.max(findMaxProfit(prices, idx+1, idx),
        findMaxProfit(prices, idx+1, buy)));
        memo[idx][buy+1] = res;
        return res;
    }
}

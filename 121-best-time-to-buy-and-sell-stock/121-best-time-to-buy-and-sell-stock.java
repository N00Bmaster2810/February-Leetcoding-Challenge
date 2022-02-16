class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[n];
        int max = prices[n-1];
        for(int i=n-2;i>=0;i--){
            next[i] = max;
            max = Math.max(max, prices[i]);
        }
        max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(next[i] - prices[i], max);
        }
        return max;
    }
}
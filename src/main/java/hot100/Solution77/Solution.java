package hot100.Solution77;

public class Solution {
    public int maxProfit(int[] prices) {
        int minLocation = 0;
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minLocation]) {
                minLocation = i;
            } else {
                maxValue = Math.max(maxValue, prices[i] - prices[minLocation]);
            }
        }
        return maxValue;
    }
}
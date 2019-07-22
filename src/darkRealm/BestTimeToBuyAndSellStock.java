package darkRealm;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

//  #121. Best Time to Buy and Sell Stock
//  Say you have an array for which the ith element is the price of a given stock on day i.
//  If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
//  design an algorithm to find the maximum profit.
//  Example 1:
//  Input: [7, 1, 5, 3, 6, 4]
//  Output: 5
//  max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//  Example 2:
//  Input: [7, 6, 4, 3, 1]
//  Output: 0
//  In this case, no transaction is done, i.e. max profit = 0.

  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int maxP = 0;
    int min = prices[0], max = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = max = prices[i];
      }
      if (prices[i] > max && maxi >= mini) {
        max = prices[i];
        maxP = Math.max(maxP, max - min);
      }
    }
    return maxP;
  }
  
  public static int maxProfitOLD(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int maxP = 0, mini = 0, maxi = 0;
    int min = prices[0], max = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = max = prices[i];
        mini = maxi = i;
      }
      if (prices[i] > max && maxi >= mini) {
        max = prices[i];
        maxi = i;
        maxP = Math.max(maxP, max - min);
      }
    }
    return maxP;
  }

  public static void main(String[] args) {
//    int[] prices = new int[]{7, 6, 4, 3, 2, 1};
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    int res = maxProfit(prices);
    System.out.println(Arrays.toString(prices));
    System.out.println("P : " + res);
  }
}

package forOffer;

public class offer63 {
    /**
     * 股票的最大利润
     * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
     */
    public int maxProfit(int[] prices){
        if(prices==null || prices.length==0)
            return 0;
        int minPrice = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            minPrice = Math.min(minPrice,prices[i]);
            res = Math.max(res,prices[i]-minPrice);
        }
        return res;
    }
}

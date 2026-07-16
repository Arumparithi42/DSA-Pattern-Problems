public class CoinExchangeII {
    public static void main(String[] args) {
        // dp = min (including,  excluding)

        final int[] coins = {1,2,5};
        int amt = 7;
        int[][] dp = new int[coins.length][amt+1];

        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < amt+1; i++){
            dp[0][i] = i % coins[0] != 0 ? amt+1 : i / coins[0];
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j < amt+1; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1 );
                }
            }
        }
        int ans = dp[coins.length-1][amt];
        // if answer not possible
        if (ans == amt+1){
            ans = 0;
        }
        System.out.println("Mininum coins : " + ans);
    }
}

public class CoinExchangeI {
    public static void main(String[] args) {
        final int[] coins = {1,2,5,10};
        final int amt = 10;

        int[][] dp = new int[coins.length][amt+1];

        // first initialize flags i.e rows of first columns
        for(int i = 0; i < coins.length; i++){
            dp[i][0] = 1;
        }
        // optimized assigning first row
        for(int i = 1; i < amt+1; i++){
            dp[0][i] = 1 % coins[0] == 0 ? 1 : 0;
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j < amt+1; j++){
                if (coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }

        System.out.println("Ways : " + dp[coins.length-1][amt]);
    }
}

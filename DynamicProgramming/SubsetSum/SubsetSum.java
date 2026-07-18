// This is a boolean problem
public class SubsetSum {
    static int issubsetsum(int[] values, int sum){
        int[][] dp = new int[values.length][sum+1];
        for(int i = 0; i < values.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < sum+1; i++){
            dp[0][i] = (i == values[0]) ? 1 : 0;
        }
        for(int i = 1; i < values.length; i++){
            for(int j = 1; j < sum+1; j++){
                if(values[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    if(dp[i-1][j] == 1){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j - values[i]];
                    }
                }
            }
        }
        return dp[values.length-1][sum];
    }
    public static void main(String[] args){
        int[] values = {2,3,5,7,10};
        int sum = 14;
        int result = issubsetsum(values,sum);
        System.out.print(result);
    }
}

import java.util.List;

public class BricksGame {
    public static int bricksGame(List<Integer> arr) {
        int total = 0;
        int[] dp = new int[arr.size()];
        for(int i = arr.size()-1, temp = 0; i >= 0; i--, temp++){
            total += arr.get(i);
            if (temp < 3){
                dp[i] = (int)total;
            }
            else{
                dp[i] = (int)total - Math.min(Math.min(dp[i+1], dp[i+2]), dp[i+3]);
            }
        }
        return dp[0];
    }
}

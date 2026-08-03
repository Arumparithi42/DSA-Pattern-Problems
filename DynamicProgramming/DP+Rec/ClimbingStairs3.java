public class ClimbingStairs3{
    public int climb3(int n){
        if (n < 4){
            return (int)Math.pow(2,n-1);
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for(int i = 3; i < n; i++){
            dp[i]= dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n-1];
    }
    public int rec(int level, int n){ // level
        // pruning - none here
        // base
        if (level == n){
            return 1; // i(this recursion) have found one way // no move is counted as one way 
        }
        int ans = 0;
        // choice
        for(int i = 1; i <= 3; i++){
            // check
            if (level + i <= n){
                // move
                ans += rec(level+i, n);
                // restore - nonve here
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ClimbingStairs3 dp = new ClimbingStairs3();
        System.out.println(dp.climb3(4));
        System.out.println(dp.rec(0, 4));
    }
}
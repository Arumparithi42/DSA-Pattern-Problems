public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i = 1; i <= n; i++){
            ans[i] = ans[i/2] + (i%2); // dp[i] = dp[i >> 1] + (i&1); // ans[i] = ans[i & (i - 1)] + 1
            // Eg: 7 : 111 => 3 : 11 + 1 (odd)
            // Eg: 6 : 110 => 3 : 11 (even)
        }
        return ans;
    }

    public int[] bruteForce(int n) { // O(n logn)
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int num = i;

            while (num > 0) {
                ans[i] += num & 1;
                num >>= 1;
            }
        }

        return ans;
    }
    
}


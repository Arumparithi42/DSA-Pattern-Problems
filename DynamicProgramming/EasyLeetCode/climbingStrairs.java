public class climbingStrairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
            
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-2] + mem[i-1];
        }
        return mem[n-1];
    }
}
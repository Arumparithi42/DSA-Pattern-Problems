import java.util.Arrays;
public class SubsetSum {

    int target = 4;
    int[] arr = {2,4,5,7};
    int n = arr.length;
    int[][] memo = new int[n][target+1];
    public int rec(int level, int sumTaken){
        // pruning 
        if (sumTaken > target)
            return 0;
        // base
        if (level == n){
            if (target == sumTaken)
                return 1;
            else
                return 0;
        }
        // transition or compute
        int ans = 0;
        if (rec(level+1, sumTaken) == 1) // not taken
            ans = 1;
        else if(rec(level+1, sumTaken + arr[level]) == 1)
            ans = 1;
        return ans;
    }
    public int recdp(int level, int sumTaken){
        // pruning 
        if (sumTaken > target)
            return 0;
        // base
        if (level == n){
            if (target == sumTaken)
                return 1;
            else
                return 0;
        }
        // cache hit
        if (memo[level][sumTaken] != -1)
            return memo[level][sumTaken];
        // transition or compute
        int ans = 0;
        if (recdp(level+1, sumTaken) == 1) // not taken
            ans = 1;
        else if(recdp(level+1, sumTaken + arr[level]) == 1)
            ans = 1;
        return memo[level][sumTaken] = ans;
    }
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        for( int[] row : ss.memo){
            Arrays.fill(row, -1) ;
        }
        System.out.println(ss.recdp(0, 0));
    }
    
}

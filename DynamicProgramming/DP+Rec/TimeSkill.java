import java.util.Arrays;
public class TimeSkill {

    /* for rec
    int[] times = {1,2,3,5};
    int[] skill = {3,4,2,1};
    
    */
    int[] visit = {0,0,0,0};
    // for dp and recdp
    int[] times = {1,2,3,5};
    int[] skill = {3,4,2,1};
     
    private boolean check(int level, int time, int k){
        int totalTime = 0;
        int timeTaken = 0; // no. of problems
        for(int i = 0; i < level; i++){
            if (visit[i] == 1){
                totalTime += times[i];
                timeTaken += 1;
            }
        }
        totalTime += times[level];
        timeTaken++;
        if(totalTime <= time && timeTaken <= k)
            return true;
        return false;
    }
    public int rec(int level, int time, int k){

        // pruning - none
        // base
        int n = times.length;
        if (level == n){
            return 0;
        }
        // choice (take or not)
        int ans = rec(level+1, time, k); // not taken
        if (check(level,time, k)){ // not taken
            visit[level] = 1;
            ans = Math.max(ans, skill[level] + rec(level+1, time,  k));
            visit[level] = 0;
        }
        return ans;
    }
    public int dp(int time, int k){
        int[][][] ans = new int[times.length][time+1][k+1];
        for(int i = 0; i < times.length ; i++){
            ans[i][0][0] = 0;
        }
        for(int i = 1; i < time+1; i++){
            ans[0][i][0] = 0;
        }
        for(int i = 1; i < k+1; i++){
            ans[0][0][i] = 0;
        }
        for(int i = 1; i < times.length; i++){
            for(int j = 1; j < time+1; j++){
                for(int c = 1; c < k + 1; c++){
                    ans[i][j][c] = ans[i-1][j][c];
                    if (c > 0 && times[i] <= j){
                        ans[i][j][c] = Math.max(ans[i][j][c], ans[i-1][j - times[i]][c-1] + skill[i]);
                    }
                }
            }
        }
        return ans[times.length-1][time][k];
    }

    int[][][] memo = new int[10][10][10];
    int n = times.length;
    public int recdp(int level, int timeTaken, int itemTaken, // states
        int time, int k) { 
        
        // pruning - none
        // base
        if (level == n){
            return 0;
        }

        // cache check
        if (memo[level][timeTaken][itemTaken] != -1){
            return memo[level][time][k];
        }

        // compute / transition
        int ans = recdp(level+1, timeTaken, itemTaken, time, k); // not taken
        if (timeTaken + times[level] <= time && itemTaken + 1 <= k){
            int ans2 = skill[level] + recdp(level+1, timeTaken + times[level], itemTaken + 1, time, k);
            ans = Math.max(ans, ans2);
        }
        // save and return
        return memo[level][timeTaken][itemTaken] = ans;
    }
    public static void main(String[] args) {
        TimeSkill ts = new TimeSkill();
        //int[] times = {1,2,3,5};
        //int[] skill = {3,4,2,1};

        for (int[][] two : ts.memo){
            for(int[] one : two){
                Arrays.fill(one, -1);
            }
        }
        System.out.println(ts.recdp(0, 0, 0, 6, 2));
    }
}

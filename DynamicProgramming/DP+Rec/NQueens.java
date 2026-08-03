public class NQueens {
    int[] board = new int[20]; // queen placed at coloumn[i] where i is row
    // level

    private boolean check(int row, int col){
        for(int i = 0; i < row; i++){
            int prevRow = i;
            int prevCol = board[prevRow];
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(prevRow - row)){
                return false;
            }
        }
        return true;
    }
    public int rec(int level, int n){ // no of ways the queens can be placed

        // pruning 
        // base
        if (level == n){
            return 1;
        }
        int ans = 0;
        // choice
        for(int col = 0; col < n; col++){
            // check
            if(check(level, col)){
                // compute
                board[level] = col; 
                // move
                ans += rec(level+1,n);
                // restore
                board[level] = -1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        NQueens queen = new NQueens();
        System.out.println(queen.rec(0, 4));
    }
}

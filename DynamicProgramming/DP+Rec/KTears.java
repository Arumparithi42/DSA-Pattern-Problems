public class KTears {
    public int rec(int level, int r, int c, int k){ // return minimum penalty = sum of squares of area
        // pruning
        // base
        if (level == k){
            return 0;
        }

        // choice
        int v = rec(level+1, r-1, c, k); // verical
        int h = rec(level+1, r, c-1, k); // horizontal
    }
}

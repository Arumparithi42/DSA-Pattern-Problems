import java.util.ArrayList;
public class SubsetSum2 { // printing answer

    int[] values = {1,2,5,9};
    int n = values.length;
    public int recdp(int level, int sumLeft){
        // pruning
        if (sumLeft < 0){
            return 0;
        }
        // base
        if (level == n){
            if (sumLeft == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        // compute or transition
        int ans = 0;
        if (recdp(level+1, sumLeft) == 1){ //  not taken
            ans = 1;
        }
        else if (recdp(level+1, sumLeft - values[level]) == 1){ // taken
            ans = 1;
        }
        return ans;
    }

    // Printing the values 
    ArrayList<Integer> answerSum = new ArrayList<>();
    public void printSum(int level, int sumLeft){
        // base
        if (level == n){
            return;
        }
        if (recdp(level+1, sumLeft) == 1){
            printSum(level+1, sumLeft);
        }
        else if(recdp(level+1, sumLeft - values[level]) == 1){
            answerSum.add(values[level]);
            printSum(level+1, sumLeft - values[level]);
        }
    }
    public static void main(String[] args) {
        SubsetSum2 sum = new SubsetSum2();
        int target = 4;
        if (sum.recdp(0, target) == 1){
            sum.printSum(0, target);
        }
        System.out.println(sum.answerSum);
    }
}

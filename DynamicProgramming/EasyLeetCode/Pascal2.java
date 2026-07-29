import java.util.ArrayList;
import java.util.List;
public class Pascal2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for( int i = 0; i <= rowIndex; i++){
            row.add(1);
        }
        for(int i = 1; i < rowIndex; i++){ // since [1] and [1,1] size is 2 is already done
            for(int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j-1));
            }
        } 
        return row;   
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int profit=0;
        for(int p: prices){
            if(p<buy){
                buy=p;
            }
            else{
                profit=Math.max(p-buy,profit);
            }
        }
        return profit;
    }
}
import java.util.Arrays;
import java.util.Comparator;
class Item{
    int profit;
    int weight;
    Item(int profit, int weight){
        this.profit = profit;
        this.weight = weight;
    }
}
public class Knapsack {
    static int knapsack(Item[] items, int capacity){
        Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item item1, Item item2){
                return Integer.compare(item1.weight, item2.weight);
            }
        });
        int[][] dp = new int[items.length+1][capacity+1];
        for(int i = 0; i < items.length+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < capacity+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < items.length+1; i++){
            for(int j = 1; j < capacity+1; j++){
                if(items[i-1].weight > j){ // Note : items are still stored from 0 to items.length-1
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - items[i-1].weight] + items[i-1].profit);
                }
            }
        }
        return dp[items.length][capacity];
    }
    public static void main(String[] args) {
        Item[] items = {
            new Item(2,3),
            new Item(3,4),
            new Item(1,6),
            new Item(4,5)
        };
        int capacity = 8;
        int result = knapsack(items, capacity);
        System.out.println("Max Profit : " + result);
    }
}

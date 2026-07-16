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
public class KnapsackFractionClass {
    
    static double maxProfit(Item[] items, int capacity){
        double[] ratio = new double[items.length];
        for(int i = 0; i < ratio.length; i++){
            ratio[i] = (double)items[i].profit / items[i].weight;
        }
        // Using Array sort O(nlogn)
        Arrays.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2){
                double ratio1 = (double)i1.profit/i1.weight;
                double ratio2 = (double)i2.profit/i2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });
        double profit = 0;
        for(Item item : items){
            if (capacity == 0)
                break;
            if (capacity > item.weight){
                profit += item.profit;
                capacity -= item.weight;
            }
            else{
                profit += ((double)capacity/item.weight)*item.profit;
                capacity = 0;
            }
        }
        return profit;
    }
    public static void main(String[] args){
        Item[] items = {new Item(60,10), 
            new Item(100,20), 
            new Item(120,30)};

        int capacity = 50;

        double maxprofit = maxProfit(items,capacity);
        System.out.println("Max Profit : " + maxprofit);
    }
}

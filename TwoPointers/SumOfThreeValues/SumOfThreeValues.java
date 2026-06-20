import java.util.*;

public class SumOfThreeValues {
    public static List<List<Integer>> threeSum(int[] nums) {
        
        // Replace this placeholder return statement with your code
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){
            if(k>0 && nums[k] == nums[k-1])
                continue;
            int target = -nums[k];
            int i = k + 1,j = nums.length - 1;
            while(i < j){
                int sum = nums[i] + nums[j];
                if (target < sum)
                    j--;
                else if (target > sum)
                    i++;
                else{
                    answer.add(Arrays.asList(nums[j],-target, nums[i]));
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i-1])
                        i++;
                    while(i < j && nums[j] == nums[j+1])
                        j--;
                }
            }
            
        }
        return (answer);
    }
}
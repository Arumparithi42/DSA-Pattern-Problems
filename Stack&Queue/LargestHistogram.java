import java.util.*;
public class LargestHistogram {
    Stack<Integer> stack = new Stack<>();
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        stack.push(0);
        int i;
        for(i = 1; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = Math.max(max,getArea(heights, i, max));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            max =  Math.max(max, getArea(heights, i, max));
        }
        return max;
    }
    private int getArea(int[] heights, int i, int max){
        int area;
        int len = heights[stack.pop()];
        if(stack.isEmpty()){
            area = len * i;
        }
        else{
            area = len * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}
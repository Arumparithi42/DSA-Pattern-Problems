import java.util.Arrays;
public class CheckSort{
    public static void main(String[] args){
        System.out.println(check(new int[] {1,2,3,6,50},  0));
    }
    static boolean check(int[] arr){
        if (arr.length <= 1){
            return true;
        }
        return (arr[0] < arr[1]) && check(Arrays.copyOfRange(arr, 1, arr.length));

    }
    static boolean check(int[] arr, int index){
        if (arr.length-1 == index){
            return true;
        }
        return (arr[index] < arr[index+1]) && check(arr, index+1);

    }
}
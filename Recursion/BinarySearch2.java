public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8};
        System.out.println(search(arr,10));
    }
    static int search(int[] arr, int target){
        return binarySearch(arr,target, 0,arr.length-1);
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        if (end > start){
            return -1;
        }
        int mid = start + (end-start)/2;
        if (arr[mid] == target){
            return mid;
        }
        else if (arr[mid] < target){
            return binarySearch(arr, target, mid+1, end);
        }
        else{
            return binarySearch(arr, target, start, mid-1);
        }
    }
}

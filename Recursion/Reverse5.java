public class Reverse5 {
    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }    
    static int reverse(int n){
        if (n % 10 == n){
            return n;
        }
        return reverse(n/10) + n%10;
    }
}

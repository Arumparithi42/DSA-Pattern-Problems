public class SumOfDigits4 {
    public static void main(String[] args) {
        System.out.println(sumOfDigit(1432));
    }    
    static int sumOfDigit(int n){
        
        if (n < 10){ // n % 10 == n
            return n;
        }

        return sumOfDigit(n/10) + n%10;
    }
}

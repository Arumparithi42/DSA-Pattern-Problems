public class Fibonacci1 {
    public static void main(String[] args) {
        //Nth finonacci : 0 1 1 2 3 5
        //              : 0 1 2 3 4 5
        System.out.println(fibo(3));
    }
    static int fibo(int n){
        if (n <= 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        int count = 0;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
            i++;
            j--;

        }
        return true;
    }
    private boolean isPalindrome(String s, int left, int rigth){
        while(left < rigth){
            if(s.charAt(left) != s.charAt(rigth)){
                return false;
            }
            left++;
            rigth--;
        }
        return true;
    }
}
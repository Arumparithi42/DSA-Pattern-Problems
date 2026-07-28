import java.util.ArrayList;
public class Permutation {
    public static void main(String[] args) {
        permu("", "abcd");
        System.out.println(ans);
    }
    static ArrayList<String> ans = new ArrayList<>();
    static void permu(String p, String up){
        if(up.isEmpty()){
            ans.add(p);
            return;
        }
        for(int i = 0; i <= p.length(); i++){
            permu(p.substring(0,i) + up.charAt(0) + p.substring(i), 
                up.substring(1));
        }
    }
    
}

import java.util.ArrayList;
public class Subset {
    static ArrayList<String> set =  new ArrayList<String>();
    public static void main(String[] args) {
        //ArrayList<String> ans = subset("", "abc");
        subset("", "abc");
        System.out.println(set.toString());
    }
    static void subset(String p, String up){
        if(up.isEmpty()){
            if (!p.isEmpty())
                set.add(p);
            return;
        }
        subset(p + up.charAt(0), up.substring(1));
        subset(p, up.substring(1));
    }
}

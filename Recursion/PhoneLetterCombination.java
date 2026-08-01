import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class PhoneLetterCombination {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        combination("", digits);
        return ans;
    }
    void combination(String p, String up){
        if (up.isEmpty()){
            ans.add(p);
            return;
        }
        String digit = map.get(up.charAt(0));
        for(int i = 0; i < digit.length(); i++ ){
            combination(p + digit.charAt(i), up.substring(1));
        }
    }
    
}
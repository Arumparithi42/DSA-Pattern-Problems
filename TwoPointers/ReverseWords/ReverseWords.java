public class ReverseWords { // To solve without using split or StringBuilder, see Java Implemetations
    public String reverseWords(String sentence) {
        String[] list = sentence.split("//s+");
        StringBuilder answer = new StringBuilder();
        for(int i = list.length-1; i >= 0; i--){
            if(!answer.isEmpty())
                answer.append(" ");
            answer.append(list[i]);
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("We Love Python"));
    }
}

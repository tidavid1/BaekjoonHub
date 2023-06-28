import java.util.ArrayList;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(temp.size() == 0){
                temp.add(word);
                continue;
            }
            String end = temp.get(temp.size()-1);
            if(temp.contains(word) || end.charAt(end.length()-1) != word.charAt(0)){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            temp.add(word);
        }
        return answer;
    }
}
import java.util.ArrayList;
class Solution {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<String>();
        for(String str: strArr){
            if(str.contains("ad")) continue;
            answer.add(str);
        }
        return answer;
    }
}
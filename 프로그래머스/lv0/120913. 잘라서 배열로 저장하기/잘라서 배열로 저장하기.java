import java.util.*;
class Solution {
    public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<String>();
        for(int i=0;i<my_str.length();i+=n){
            answer.add(my_str.substring(i, i+n > my_str.length()?my_str.length():i+n));
        }
        return answer;
    }
}
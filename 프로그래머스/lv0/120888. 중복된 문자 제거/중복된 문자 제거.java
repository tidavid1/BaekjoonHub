import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String my_string) {
        ArrayList<Character> temp = new ArrayList<>();
        for(char c:my_string.toCharArray()){
            if(temp.contains(c)) continue;
            temp.add(c);
        }
        return temp.stream().map(Object::toString).collect(Collectors.joining());
    }
}
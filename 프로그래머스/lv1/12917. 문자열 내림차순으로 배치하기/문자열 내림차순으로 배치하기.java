import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(Object s1: Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).toArray()){
            sb.append(s1);
        }
        return sb.toString();
    }
}
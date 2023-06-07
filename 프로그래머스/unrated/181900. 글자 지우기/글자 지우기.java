import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<my_string.length();i++){
            for(int j: indices){
                if(j==i){
                    flag=false;
                    break;
                }
            }
            if(flag) sb.append(my_string.charAt(i));
            flag=true;
        }
        return sb.toString();
    }
}
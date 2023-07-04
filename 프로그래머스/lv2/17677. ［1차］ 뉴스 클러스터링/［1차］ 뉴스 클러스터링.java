import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            String temp = str1.substring(i,i+2);
            if(temp.matches("[A-Z]+")){
                set1.add(temp);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String temp = str2.substring(i,i+2);
            if(temp.matches("[A-Z]+")){
                set2.add(temp);
            }
        }
        int max = set1.size()+set2.size();
        int min = 0;
        for(String s:set1){
            if(set2.remove(s)){
                min+=1;
            }
        }
        max -= min;
        double answer = min==0&&max==0?1:(double)min/(double)max;
        return (int)(answer*65536);
    }
}
import java.util.*;
class Solution {
    public String solution(String X, String Y) {
StringBuilder sb = new StringBuilder();
        List<String> table = new ArrayList<>();
        int[] table_x = new int[10];
        int[] table_y = new int[10];
        for(char x:X.toCharArray()){
            table_x[x-'0'] += 1;
        }
        for(char y:Y.toCharArray()){
            table_y[y-'0'] += 1;
        }
        for(int i=0;i<table_x.length;i++){
            for(int j = 0;j<Math.min(table_x[i], table_y[i]);j++){
                table.add(String.valueOf(i));
            }
        }
        table.sort(Comparator.reverseOrder());
        if(table.size() == 0){
            sb.append("-1");
        }else if(table.stream().mapToInt(Integer::parseInt).sum() == 0){
            sb.append("0");
        }else{
            for(String s:table){
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
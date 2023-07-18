import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            temp[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));
        if(temp[0].equals("0"))
            return "0";
        for(String s:temp){
            sb.append(s);
        }
        return sb.toString();
    }
}
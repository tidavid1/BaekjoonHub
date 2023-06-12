import java.util.Arrays;
class Solution {
    public long solution(long n) {
        int[] temp = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        temp = Arrays.stream(temp).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        for(int i=temp.length-1;i>=0;i--){
            sb.append(temp[i]);
        }
        return Long.parseLong(sb.toString());
    }
}
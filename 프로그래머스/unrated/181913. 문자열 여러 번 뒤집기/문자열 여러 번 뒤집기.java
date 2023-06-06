class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] answer = my_string.toCharArray();
        for(int[] query: queries){
            int v = (int)Math.round(((double)query[1]-(double)query[0])/2.);
            for(int i=0;i<v;i++){
                char temp = answer[query[0]];
                answer[query[0]++] = answer[query[1]];
                answer[query[1]--] = temp;
            }
        }
        return new String(answer);
    }
}
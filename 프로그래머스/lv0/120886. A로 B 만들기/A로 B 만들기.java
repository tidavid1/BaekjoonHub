class Solution {
    public int solution(String before, String after) {
        StringBuilder sb = new StringBuilder(after);
        for(char c:before.toCharArray()){
            if(sb.indexOf(String.valueOf(c)) == -1){
                return 0;
            }
            sb.deleteCharAt(sb.indexOf(String.valueOf(c)));
        }
        return 1;
    }
}
class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for(char c:rsp.toCharArray()){
            switch(c){
                case '2' -> sb.append("0");
                case '0' -> sb.append("5");
                default -> sb.append("2");
            }
        }
        return sb.toString();
    }
}
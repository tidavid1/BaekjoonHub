class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        for(int i=0;i<code.length();i++){
            if(code.charAt(i) == '1'){
                mode = mode == 0 ? 1 : 0;
                continue;
            }
            sb.append(i%2==mode ? code.charAt(i) : "");
        }
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}
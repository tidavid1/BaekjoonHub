class Solution {
    public boolean solution(int x) {
        int dividend = 0;
        for(char c:String.valueOf(x).toCharArray()){
            dividend += c-'0';
        }
        return x%dividend == 0? true : false;
    }
}
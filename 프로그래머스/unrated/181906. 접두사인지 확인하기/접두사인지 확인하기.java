class Solution {
    public int solution(String my_string, String is_prefix) {
        for(int i=0;i<my_string.length();i++){
            if(is_prefix.equals(my_string.substring(0, i))){
                return 1;
            }
        }
        return 0;
    }
}
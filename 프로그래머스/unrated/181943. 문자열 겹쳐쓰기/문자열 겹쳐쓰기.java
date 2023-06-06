class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] overwrite = overwrite_string.toCharArray();
        char[] my = my_string.toCharArray();       
        System.arraycopy(overwrite, 0, my, s, overwrite.length);
        return new String(my);
    }
}
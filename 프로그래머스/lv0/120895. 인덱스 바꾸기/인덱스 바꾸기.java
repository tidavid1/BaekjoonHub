class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] char_array = my_string.toCharArray();
        char temp = char_array[num1];
        char_array[num1] = char_array[num2];
        char_array[num2] = temp;
        StringBuilder sb = new StringBuilder();
        for(char c: char_array) sb.append(c);
        return sb.toString();
    }
}
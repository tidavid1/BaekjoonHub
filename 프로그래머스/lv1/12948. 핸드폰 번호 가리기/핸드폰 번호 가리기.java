class Solution {
    public String solution(String phone_number) {
        String maskedDigits = new String(new char[phone_number.length() - 4]).replace('\0', '*');
        return maskedDigits + phone_number.substring(phone_number.length() - 4);
    }
}
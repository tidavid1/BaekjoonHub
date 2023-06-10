class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] temp = numbers.clone();
        if(direction.equals("right")){
            for(int i=1;i<numbers.length;i++){
                numbers[i] = temp[i-1];
            }
            numbers[0] = temp[temp.length-1];
        }else{
            for(int i=0;i<numbers.length-1;i++){
                numbers[i] = temp[i+1];
            }
            numbers[numbers.length-1] = temp[0];
        }
        return numbers;
    }
}
class Solution {
    public int solution(int price) {
        if(price/100000 >= 5){
            return (int)(price - price*.2);
        }else if(price /100000 >= 3){
            return (int)(price - price*.1);
        }else if (price/100000 >= 1){
            return (int)(price - price*.05);
        }else{
            return price;
        }
    }
}
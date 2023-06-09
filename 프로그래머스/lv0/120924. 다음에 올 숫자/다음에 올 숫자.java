class Solution {
    public boolean check(int[] arr){
        return arr[1]-arr[0] == arr[2]- arr[1] ? true : false;
    }
    public int solution(int[] common) {
        if(check(common)){
            return common[common.length-1] + (common[common.length-1]-common[common.length-2]);
        }else{
            return common[common.length-1] * (common[1]/common[0]);
        }
    }
}
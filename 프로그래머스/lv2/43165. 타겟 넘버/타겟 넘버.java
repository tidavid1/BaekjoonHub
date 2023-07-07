class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        DFS(0, "+", numbers, target, 0);
        DFS(0, "-", numbers, target, 0);
        return answer;
    }

    public void DFS(int depth, String s,int[] numbers, int target, int temp){
        if(s.equals("+")){
            temp += numbers[depth];
        }else{
            temp -= numbers[depth];
        }
        if(depth+1 == numbers.length){
            if(temp == target){
                answer += 1;
            }
            return;
        }
        DFS(depth+1, "+", numbers, target, temp);
        DFS(depth+1, "-", numbers, target, temp);
    }
}
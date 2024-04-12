class Solution {

    private boolean[] visited;
    private int depth = 0;

    public int[] solution(int n, long k) {
        int[] numbers = new int[n];
        int[] result = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        k -= 1;
        while(depth < result.length) {
            var temp = factorial(n - 1);
            var count = (int) (k / temp);
            var idx = countIdx(count);
            visited[idx] = true;
            result[depth++] = numbers[idx];
            k %= temp;
            n -= 1;
        }
        return result;
    }


    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private int countIdx(int n) {
        int idx = 0;
        int count = -1;
        while (count < n) {
            count += visited[idx++] ? 0 : 1;
        }
        return idx - 1 ;
    }
}
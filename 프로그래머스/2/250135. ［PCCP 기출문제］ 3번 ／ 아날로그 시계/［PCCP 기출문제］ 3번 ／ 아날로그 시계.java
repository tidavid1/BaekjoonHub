class Solution {
    private static final int HOUR_TO_SECONDS = 3600;
    private static final int MINUTE_TO_SECONDS = 60;
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int begin = toSeconds(h1, m1, s1);
        int end = toSeconds(h2, m2, s2);
        int answer = calculateAlarm(end) - calculateAlarm(begin);
        if(begin * 59 % HOUR_TO_SECONDS == 0 || begin * 719% (HOUR_TO_SECONDS * 12) == 0){
            answer += 1;
        }
        return answer;
    }
    
    private int calculateAlarm(int seconds) {
        int alarmMinute = seconds * 59 / HOUR_TO_SECONDS;
        int alarmHour = seconds * 719 / (HOUR_TO_SECONDS * 12);
        int noon = seconds < HOUR_TO_SECONDS * 12 ? 1 : 2;
        return alarmMinute + alarmHour - noon;
    }
    
    private int toSeconds(int hour, int minute, int second) {
        return hour * HOUR_TO_SECONDS + minute * MINUTE_TO_SECONDS + second;
    }
}
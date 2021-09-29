using System;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] having = new int[n];
        int answer = 0;
        
        for (int i = 0; i < reserve.Length; i++) {
            having[reserve[i]-1] += 1;
        }
        
        for (int i = 0; i < lost.Length; i++) {
            having[lost[i]-1] -= 1;
        }

        for (int i = 0; i < n; i++) {
            if (having[i] < 0) {
                if (i > 0 && having[i-1] > 0) {
                    having[i]++;
                    having[i-1]--;
                } else if (i < n-1 && having[i+1] > 0) {
                    having[i]++;
                    having[i+1]--;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (having[i] >= 0)
                answer++;
        }
        
        return answer;
    }
}

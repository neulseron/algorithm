using System;

public class Solution {
    public int[] solution(int[] array, int[,] commands) {
        int[] answer = new int[commands.GetLength(0)];
        
        for (int i = 0; i < commands.GetLength(0); i++) {
            int commArrLength = commands[i, 1] - commands[i, 0] + 1;
            int[] commArr = new int[commArrLength];
            
            for (int j = 0; j < commArrLength; j++) {
                commArr[j] = array[commands[i, 0] - 1 + j];
            }
            
            Array.Sort(commArr);
            
            answer[i] = commArr[commands[i, 2] - 1];
        }
        
        return answer;
    }
}

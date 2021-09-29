using System;

public class Solution {
    int answer = 0;
    int maxTurn;
    int[] numbersArr;
    
    public void dfs(int value, int target, int turn)
    {
        if (turn >= maxTurn) {
            if (value == target) {
                answer++;
            }
            return;
        }
        
        
        dfs(value - numbersArr[turn], target, turn + 1);
        dfs(value + numbersArr[turn], target, turn + 1);
    }
    
    public int solution(int[] numbers, int target) 
    {
        maxTurn = numbers.Length;
        numbersArr = numbers;
        
        dfs(0, target, 0);
        
        return answer;
    }

}

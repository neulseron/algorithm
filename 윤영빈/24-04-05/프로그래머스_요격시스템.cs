using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int[,] targets) {
        int answer = 0;

        if (targets.Length == 0)
            return answer;

        answer = 1;

        List<Tuple<int, int>> targetList = new List<Tuple<int, int>>();
        for (int i = 0; i < targets.GetLength(0); ++i)
            targetList.Add(new Tuple<int, int>(targets[i, 0], targets[i, 1]));
        
        targetList.Sort();

        int point = int.MaxValue;
        for (int i = 0; i < targetList.Count; ++i)
        {
            if (targetList[i].Item2 < point)
            {
                point = targetList[i].Item2;
                continue;
            }

            if (targetList[i].Item1 >= point)
            {
                point = targetList[i].Item2;
                answer++;
            }
        }

        return answer;
    }
}

// cs로 2차원배열을 처음 써봐서 헤맸다..

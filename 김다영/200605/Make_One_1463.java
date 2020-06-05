package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Make_One_1463 {
	static int[] cal = {3, 2, 1};
	static int[] dp;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[1] = 0;
		Solve(N);
		System.out.println(dp[N]);
	}
	
	public static void Solve(int cnt)
	{
		int tmp;
		for(int i = 2; i <= cnt; i++)
		{
			tmp = Integer.MAX_VALUE;
			if(i % 3 == 0)
				tmp = Math.min(dp[i / 3] + 1, tmp);
			if(i % 2 == 0)
				tmp = Math.min(dp[i / 2] + 1, tmp);
			dp[i] = Math.min(dp[i - 1] + 1, tmp);
		}
	}
}
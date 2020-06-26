package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge_Construction_1010 {
	static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int M, N;
		dp = new int[30][30];
		int tc, i;
		for(i = 1; i < 30; i++)
		{
			dp[1][i] = i;
			dp[i][i] = 1;
		}
		for(tc = 0; tc < T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			dp[M][N] = DP(M, N);
			System.out.println(dp[M][N]);
		}
	}
	
	private static int DP(int x, int y)
	{
		int answer = 0;
		if(dp[x][y] != 0)
			return dp[x][y];
		for(int i = y - 1; i >= x - 1; i--)
			answer += DP(x - 1, i);
		return answer;
	}
}
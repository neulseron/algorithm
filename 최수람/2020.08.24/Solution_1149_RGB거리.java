package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1149_RGB거리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int dp[][]=new int [3][N];
		int cost[][]=new int [N][3];
		StringTokenizer st=null;
		int answer=Integer.MAX_VALUE;
		//0:R  1:G  2:B
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			cost[i][0]=Integer.parseInt(st.nextToken());
			cost[i][1]=Integer.parseInt(st.nextToken());
			cost[i][2]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<3;i++) {
			dp[i][0]=cost[0][i];
		}
		for(int i=1;i<N;i++) {
			dp[0][i]=Math.min(dp[1][i-1]+cost[i][0], dp[2][i-1]+cost[i][0]);
			dp[1][i]=Math.min(dp[0][i-1]+cost[i][1], dp[2][i-1]+cost[i][1]);
			dp[2][i]=Math.min(dp[0][i-1]+cost[i][2], dp[1][i-1]+cost[i][2]);
		}
		for(int i=0;i<3;i++) {
			answer=Math.min(answer, dp[i][N-1]);
		}
		System.out.println(answer);
	}//end of main
}//end of class 

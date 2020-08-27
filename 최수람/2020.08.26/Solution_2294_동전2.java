package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2294_동전2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N,K;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int coins[]=new int[N+1];
		int dp[][]=new int [N+1][K+1];
		for(int i=1;i<=N;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=K;i++) {
			dp[1][i]=i%coins[1]==0? i/coins[1]:Integer.MAX_VALUE;
		}
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(coins[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					if(dp[i][j-coins[i]]!=Integer.MAX_VALUE) {
						dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i]]+1);						
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}
			}
		}
		System.out.println(dp[N][K]==Integer.MAX_VALUE? -1:dp[N][K]);
	}//end of main	
}//end of class 

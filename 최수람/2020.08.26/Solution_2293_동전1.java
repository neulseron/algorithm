package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2293_동전1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N,K;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int nums[]=new int [N+1];
		long dp[][]=new long [N+1][K+1];
		for(int i=1;i<=N;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=K;i++) {
			dp[1][i]=i%nums[1]==0? 1:0;
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(j<nums[i]) {
					dp[i][j]=dp[i-1][j];
				}else if(j==nums[i]) {
					dp[i][j]=dp[i-1][j]+1;
				}else {
					dp[i][j]=dp[i-1][j]+dp[i][j-nums[i]];
				}
			}
		}
		System.out.println(dp[N][K]);
	}//end of main
}//end of class 

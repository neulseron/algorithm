package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long dp[][]=new long [N+1][10];
		long answer=0;
		for(int i=1;i<=9;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][1]%1000000000;
				}else if(j==9) {
					dp[i][j]=dp[i-1][8]%1000000000;
				}else {
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
				}
			}
		}
		for(int i=0;i<=9;i++) {
			answer=(answer+dp[N][i])%1000000000;
		}
		System.out.println(answer%1000000000);
	}//end of main
}//end of class 

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_9461_파도반수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			long dp[]=new long [N+1];
			dp[1]=1;
			if(N>=2) {
				dp[2]=1;
				for(int i=3;i<=N;i++) {
					dp[i]=dp[i-2]+dp[i-3];				
				}
			}
			System.out.println(dp[N]);
		}
	}//end of main
}//end of class 

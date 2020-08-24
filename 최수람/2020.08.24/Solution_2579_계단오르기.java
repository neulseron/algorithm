package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2579_계단오르기{

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int []scores=new int [N+1];
		int []dp=new int [N+1];
		for(int i=1;i<=N;i++) {
			scores[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=scores[1];
		if(N>=2) {
			dp[2]=scores[1]+scores[2];			
		}
		for(int i=3;i<=N;i++) {
			dp[i]=Math.max(dp[i-3]+scores[i-1]+scores[i], dp[i-2]+scores[i]);
		}
		System.out.println(dp[N]);
	}//end of main
}//end of class 

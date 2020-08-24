package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2156_포도주시식{

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int value[]=new int [N+1];
		int dp[]=new int [N+1];
		for(int i=1;i<=N;i++) {
			value[i]=Integer.parseInt(br.readLine());
		}
		int answer=0;
		dp[1]=value[1];
		if(N>=2) {
			dp[2]=Math.max(dp[1],value[1]+value[2]);
			for(int i=3;i<=N;i++) {
				dp[i]=Math.max(dp[i-1],Math.max(dp[i-3]+value[i-1]+value[i], dp[i-2]+value[i]));
				
			}
		}
		for(int i=1;i<=N;i++) {
			answer=Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}//end of main
}//end of class 

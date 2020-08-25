package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int nums[]=new int [N];
		int dp[]=new int [N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=nums[0];
		int answer=dp[0];
		for(int i=1;i<N;i++) {
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			answer=Math.max(answer,dp[i]);
		}
		System.out.println(answer);
	}//end of main
}//end of class 

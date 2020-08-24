package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_14697_방배정하기_dp {
	static int A,B,C,N;
	static int nums[];
	static int dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		nums=new int [3];
		nums[0]=Integer.parseInt(st.nextToken());
		nums[1]=Integer.parseInt(st.nextToken());
		nums[2]=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		dp=new int [N+1];
		//가능하면 1, 불가능하면 0
		
		for(int i=1;i<=N;i++) {
			if(i%nums[0]==0) {
				dp[i]=i/nums[0];
			}else {
				dp[i]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=nums[1];i<=N;i++) {
			if(i%nums[1]==0) {
				dp[i]=Math.min(dp[i], i/nums[1]);
			}else {
				if(dp[i-nums[1]]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], dp[i-nums[1]]+1);
				}
			}
		}
	
		for(int i=nums[2];i<=N;i++) {
			if(i%nums[2]==0) {
				dp[i]=Math.min(dp[i], i/nums[2]);
			}else {
				if(dp[i-nums[2]]!=Integer.MAX_VALUE) {
					dp[i]=Math.min(dp[i], dp[i-nums[2]]+1);
				}
			}
		}
		System.out.println(dp[N]!=Integer.MAX_VALUE? 1:0);
	}//end of main
}//end of class 

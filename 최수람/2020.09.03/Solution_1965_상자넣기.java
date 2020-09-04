package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1965_상자넣기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int nums[]=new int [n];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int dp[]=new int [n];
		int answer=0;
		Arrays.fill(dp, 1);
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					
				}
			}
		}
		for(int i=0;i<n;i++) {
			answer=Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}//end of main
}//end of class 

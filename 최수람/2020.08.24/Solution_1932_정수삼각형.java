package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1932_정수삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int value[][]=new int [N][N+1];
		int dp[][]=new int [N][N+1];
		StringTokenizer st=null;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<i+1;j++) {
				value[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=value[0][0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][j]+value[i][j];
				}else if(j==i) {
					dp[i][j]=dp[i-1][j-1]+value[i][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j]+value[i][j], dp[i-1][j-1]+value[i][j]);
				}
			}
		}
		int answer=0;
		for(int i=0;i<N+1;i++) {
			answer=Math.max(dp[N-1][i], answer);
		}
		System.out.println(answer);
	}//end of main
}//end of class 

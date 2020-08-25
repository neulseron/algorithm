package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//완탐으로 생각해보기  ==> 시간 초과 
//memo ==> 시간 초과 
//dp로 풀기 
public class Solution_1010_다리놓기 {
	static long answer;
	static int N,M;
	static long dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			answer=0;
			dp=new long [N+1][M+1];
			for(int i=1;i<=M;i++) {
				dp[1][i]=1;
			}
			for(int i=2;i<=N;i++) {
				for(int j=i;j<=M;j++) {
					long res=0;
					for(int k=1;k<j;k++) {
						res+=dp[i-1][k];
					}
					dp[i][j]=res;
				}
			}
			for(int i=1;i<=M;i++) {
				answer+=dp[N][i];
			}
			System.out.println(answer);
		}
	}//end of main
	
}//end of class 

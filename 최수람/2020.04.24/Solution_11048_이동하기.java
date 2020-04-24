import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11048_이동하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int map[][]=new int [N+1][M+1];
		for(int i=1;i<=N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int dp[][]=new int [N+1][M+1];
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				dp[i][j]=Math.max(dp[i][j-1], Math.max(dp[i-1][j],dp[i-1][j-1]))+map[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}// end of main
}//end of class

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1890_점프 {
	static int N;
	static int map[][];
	static long dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		dp=new long [N][N];
		for (long [] arr : dp) {
			Arrays.fill(arr, -1);
		}
		StringTokenizer st=null;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		long res=dfs(0,0);
		System.out.println(res);
	}//end of main
	private static long dfs(int x, int y) {
		if(x<0||x>=N||y<0||y>=N)
			return 0;
		if(dp[x][y]!=-1)
			return dp[x][y];
		if(x==N-1&&y==N-1) {
			return 1;
		}
		int num=map[x][y];
		if(num==0) {
			return 0;
		}
		dp[x][y]=dfs(x+num,y)+dfs(x,y+num);
		return dp[x][y];
	}
}//end of class 

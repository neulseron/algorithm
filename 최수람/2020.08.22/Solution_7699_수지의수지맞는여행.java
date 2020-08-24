package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {
	static int R,C,answer;
	static char map[][];
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			answer=0;
			map=new char[R][C];
			check=new boolean [100];
			for(int i=0;i<R;i++) {
				String str=br.readLine();
				for(int j=0;j<C;j++) {
				 map[i][j]=str.charAt(j);
				}
			}
			check[map[0][0]]=true;
			dfs(0,0,1);
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	static int dir[][]= {{0,-1},{0,1},{-1,0},{1,0}};
	private static void dfs(int x, int y, int cnt) {
		boolean con=false;
		for(int d=0;d<4;d++) {
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx>=0&&nx<R&&ny>=0&&ny<C) {
				if(!check[map[nx][ny]]) {
					con=true;
					check[map[nx][ny]]=true;
					dfs(nx,ny,cnt+1);
					check[map[nx][ny]]=false;
				}
			}
		}
		if(!con) {
			answer=Math.max(answer, cnt);
			return;
		}
	}
}//end of class 

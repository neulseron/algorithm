

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2210_숫자판점프 {
	static final int N=5;
	static int map[][];
	static HashSet<Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new int [N][N];
		set=new HashSet<>();
		StringTokenizer st=null;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				dfs(map[i][j]+"",1,i,j);
			}
		}
		System.out.println(set.size());
	}//end of main
	static int [][] dir={{-1,0},{1,0},{0,-1},{0,1}};
	private static void dfs(String string, int cnt,int x,int y) {
		if(cnt==6){
			set.add(Integer.parseInt(string));
			return ;
		}
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=N) continue;
			String str=string+map[nx][ny];
			dfs(str,cnt+1,nx,ny);
		}
	}
}//end of class 

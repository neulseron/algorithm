import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1941_소문난칠공주 {
	static final int N=5;
	static char map[][];
	static boolean check[][];
	static boolean visit[];
	static int cnt;
	private static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new char [N][N];
		for(int i=0;i<N;i++){
			map[i]=br.readLine().toCharArray();
		}
		//1. 25개 중에 7개 고르기 - 조합
		
		for(int i=0;i<25;i++){
			check=new boolean[N][N];
			visit=new boolean [N*N];
			dfs(i,1,0);
			
		}
		
		//3. 연결되었으면 answer++;
		System.out.println(answer);
	}//end of main
	private static void dfs(int start, int cnt, int scnt) {
		if(map[start/5][start%5]=='S'){
			++scnt;
		}
		check[start/5][start%5]=true;
		visit[start]=true;
		if(cnt==7){
			if(scnt>=4){
				//2. 7개 원소중 s가 4개 이상인 경우 연결되었는지 검사
				find();
			}
		}else{
			for(int i=start+1;i<25;i++){
				if(!visit[i]){
					dfs(i,cnt+1,scnt);
				}
			}	
		}
		check[start/5][start%5]=false;
		visit[start]=false;
	}
	private static void find() {
		for(int i=0;i<25;i++){
			if(visit[i]){
				int x=i/5;
				int y=i%5;
				boolean newcheck[][]=new boolean[5][5];
				newcheck[x][y]=true;
				cnt=1;
				isConnect(x, y, newcheck);
				return;
			}
		}
		
	}
	static int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
	private static void isConnect(int x, int y, boolean[][] newcheck) {
		if(cnt==7){
			answer++;
			return ;
		}
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(0<=nx && nx<5&&0<=ny&&ny<5){
				if(check[nx][ny]&&!newcheck[nx][ny]){
					newcheck[nx][ny]=true;
					++cnt;
					isConnect(nx,ny,newcheck);
				}	
			}
		}
	}
}//end of class 

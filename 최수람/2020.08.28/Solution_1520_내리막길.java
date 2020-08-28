package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1520_내리막길 {
	static int N,M;
	static int map[][];
	static boolean visit[][];
	static int memo[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		visit=new boolean [N][M];
		memo=new int [N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(memo[i], -1);
		}
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visit[0][0]=true;
		dfs(0,0);
		System.out.println(memo[0][0]);
	}//end of main
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static int dfs(int x, int y) {
		//경로가 가능하지 않은 경우, 새로 들어온 경우를 구분하지 못함 
		//그래서 경로가 가능하지 않은 경우 계속 똑같은 호출을 반복함 
		if(memo[x][y]!=-1)
			return memo[x][y];
		if(x==N-1 && y==M-1) {
			return 1;
		}
		int res=0;
		for(int d=0;d<4;d++) {
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			if(!visit[nx][ny]&&map[nx][ny]<map[x][y]) {
				visit[nx][ny]=true;
				res+=dfs(nx,ny);
				visit[nx][ny]=false;
			}
		}
		return memo[x][y]=res;
	}
}//end of class 

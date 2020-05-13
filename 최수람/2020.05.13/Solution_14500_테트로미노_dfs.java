import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14500_테트로미노_dfs {
	static int N,M;
	static int map[][];
	static int answer;
	static boolean check[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		check=new boolean[N][M];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int res[][][]={{{0,0},{0,1},{1,1},{0,2}},{{0,0},{0,1},{-1,1},{1,1}},{{0,0},{0,1},{-1,1},{0,2}},{{0,0},{1,0},{2,0},{1,1}}};
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				check[i][j]=true;
				dfs(i,j,1,map[i][j]);	
				check[i][j]=false;
				for(int k=0;k<4;k++){
					int sum=0;
					for(int n=0;n<4;n++){
						int ni=i+res[k][n][0];
						int nj=j+res[k][n][1];
						if(0<=ni&&ni<N&&0<=nj&&nj<M){
							sum+=map[ni][nj];							
						}
					}
					answer=Math.max(sum, answer);
				}
			}
		}
		System.out.println(answer);
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void dfs(int x,int y,int cnt, int sum) {
		if(cnt>=4){
			answer=Math.max(answer, sum);
			return ;
		}
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(0<=nx&&nx<N&&0<=ny&&ny<M){
				if(!check[nx][ny]){
					check[nx][ny]=true;
					dfs(nx,ny,cnt+1,sum+map[nx][ny]);
					check[nx][ny]=false;
				}			
			}			
		}
	}
}//end of class

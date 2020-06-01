import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17070_파이프옮기기1 {
	static int N;
	static int map[][];
	static boolean visit[][][];
	static int answer;
	static class Pipe{
		int sx;
		int sy;
		int ex;
		int ey;
		int d;
		public Pipe(int sx, int sy, int ex, int ey, int d) {
			super();
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
			this.d = d;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		visit=new boolean [N][N][3];
		StringTokenizer st=null;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,0,1,0);
		System.out.println(answer);
	}//end of main
	static int dir[][]={{0,1},{1,0},{1,1}};
	private static void dfs(int sx, int sy, int ex, int ey, int d) {
	
		if(ex==N-1&&ey==N-1){
			answer++;
			return ;
		}
		boolean con=true;
		int nex = 0,ney = 0;
		switch(d){
		case 0:
			for(int i=0;i<3;i++){
				nex=ex+dir[i][0];
				ney=ey+dir[i][1];
				if(0>nex||nex>=N||0>ney||ney>=N){
					con=false;
				}else{
					if(map[nex][ney]!=0){
						con=false;
					}
				}
				if(0<=nex&&nex<N&&0<=ney&&ney<N&&map[nex][ney]==0){
					if(i==0){
						dfs(ex, ey, nex, ney, 0);
					}
				}
			}
			if(con){
				dfs(ex, ey, nex, ney, 2);
			}
			break;
		case 1:
			for(int i=0;i<3;i++){
				nex=ex+dir[i][0];
				ney=ey+dir[i][1];
				if(0>nex||nex>=N||0>ney||ney>=N){
					con=false;
				}else{
					if(map[nex][ney]!=0){
						con=false;
					}
				}
				if(0<=nex&&nex<N&&0<=ney&&ney<N&&map[nex][ney]==0){
					if(i==1){
						dfs(ex, ey, nex, ney, 1);
					}
				}
			}
			if(con){
				dfs(ex, ey, nex, ney, 2);
			}
			break;
		case 2:
			for(int i=0;i<3;i++){
				nex=ex+dir[i][0];
				ney=ey+dir[i][1];
				if(0>nex||nex>=N||0>ney||ney>=N){
					con=false;
				}else{
					if(map[nex][ney]!=0){
						con=false;
					}
				}
				if(0<=nex&&nex<N&&0<=ney&&ney<N&&map[nex][ney]==0){
					if(i<2)
						dfs(ex, ey, nex, ney, i);
					}
				}
			if(con){
				dfs(ex, ey, nex, ney, 2);
			}
			break;
		}
	}
}//end of class 

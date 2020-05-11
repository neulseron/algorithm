import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14503_로봇청소기 {
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		int sx,sy,sd;
		st=new StringTokenizer(br.readLine()," ");
		sx=Integer.parseInt(st.nextToken());
		sy=Integer.parseInt(st.nextToken());
		sd=Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int answer=bfs(sx,sy,sd);
		System.out.println(answer);
	}//end of main
	static int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
	private static int bfs(int sx, int sy, int sd) {
		int cnt=0;
		Queue<int []> q=new LinkedList<int[]>();
		boolean check[][]=new boolean[N][M];
		q.offer(new int []{sx,sy,sd});
		check[sx][sy]=true;// 청소여부 
		cnt++;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			int d=cur[2];
			boolean con=false;
			for(int i=0;i<4;i++){
				switch(d){
				case 0:
					d=3;
					break;
				case 1:
					d=0;
					break;
				case 2:
					d=1;
					break;
				case 3:
					d=2;
					break;
				}
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(!check[nx][ny]&&map[nx][ny]==0){
					check[nx][ny]=true;
					q.add(new int []{nx,ny,d});
					cnt++;
					con=true;
					break;
				}
			}
			if(!con){
				int nx=x-dir[d][0];
				int ny=y-dir[d][1];
				if(map[nx][ny]==0){
					q.add(new int []{nx,ny,d});					
				}
				else 
					continue;
			}
		}
		return cnt;
	}
}//end of class 

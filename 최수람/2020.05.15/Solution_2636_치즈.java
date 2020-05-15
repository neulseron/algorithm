

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2636_치즈 {
	static int N,M;
	static int map[][];
	static int cnt;
	static boolean check[][],contain[][];
	static List<int []> melt;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		melt=new LinkedList<>();
		int preCnt=0,time=0;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					cnt++;
			}
		}
		while(cnt!=0){
			time++;
			preCnt=cnt;
			check=new boolean [N][M];
			contain=new boolean [N][M];
			melt.clear();
			bfs();
			mapClear();
		}
		System.out.println(time);
		System.out.println(preCnt);
	}//end of main
	private static void mapClear() {
		cnt-=melt.size();
		for(int i=0;i<melt.size();i++){
			int x=melt.get(i)[0];
			int y=melt.get(i)[1];
			map[x][y]=0;
		}
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		Queue<int []> q=new LinkedList<int[]>();
		q.add(new int []{0,0});
		check[0][0]=true;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!check[nx][ny]&&map[nx][ny]==0){
					check[nx][ny]=true;
					isEdge(nx,ny);
					q.add(new int []{nx,ny});
				}
			}
		}
	}
	private static void isEdge(int x, int y) {
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			if(map[nx][ny]==1){
				if(!contain[nx][ny]){
					contain[nx][ny]=true;
					melt.add(new int []{nx,ny});
				}
			}
		}
	}
}//end of class 

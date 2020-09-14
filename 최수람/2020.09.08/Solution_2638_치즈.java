package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2638_치즈 {
	static int N,M;
	static int map[][];
	static int cnt;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		while(cnt>0) {
			//테두리 bfs
			bfs();
			//치즈 녹이기
			melt();
			answer++;
		}
		System.out.println(answer);
	}//end of main
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void melt() {
		List<int []> melting= new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int c=0;
				if(map[i][j]==1) {
					for(int d=0;d<4;d++) {
						int nx=i+dir[d][0];
						int ny=j+dir[d][1];
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(map[nx][ny]==2) {
							c++;
							if(c>=2) {
								melting.add(new int [] {i,j});
								break;
							}
						}
					}
				}
			}
		}
		for(int i=0;i<melting.size();i++) {
			int x=melting.get(i)[0];
			int y=melting.get(i)[1];
			map[x][y]=2;
			cnt--;
		}
	}
	private static void bfs() {
		Queue<int[]> q=new LinkedList<>();
		boolean visit[][]=new boolean [N][M];
		q.add(new int [] {0,0});
		visit[0][0]=true;
		map[0][0]=2;
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			for(int d=0;d<4;d++) {
				int nx=cur[0]+dir[d][0];
				int ny=cur[1]+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!visit[nx][ny]&&map[nx][ny]!=1) {
					visit[nx][ny]=true;
					map[nx][ny]=2;
					q.add(new int [] {nx,ny});
				}
			}
		}
	}
}//end of class 

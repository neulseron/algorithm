package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	static int N,M;
	static int map[][];
	static int answer;
	static int cost;
	static int totalHome;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new int [N][N];
			cost=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1)
						totalHome++;
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					bfs(i,j);
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs(int sx, int sy) {
		Queue<int []> q=new LinkedList<int[]>();
		boolean visit[][]=new boolean[N][N];
		q.add(new int [] {sx,sy});
		visit[sx][sy]=true;
		int k=1;
		int home=0;
		if(map[sx][sy]==1) {
			home=1;
			if(1*M-1>=0) {
				answer=Math.max(answer,1);
			}
		}
		while(!q.isEmpty()) {
			int qSize=q.size();
			for(int i=0;i<qSize;i++) {
				int cur[]=q.poll();
				int x=cur[0];
				int y=cur[1];
				for(int d=0;d<4;d++) {
					int nx=x+dir[d][0];
					int ny=y+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(!visit[nx][ny]) {
						if(map[nx][ny]==1) home++;
						visit[nx][ny]=true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			k++;
			int c=k*k+(k-1)*(k-1);
			if(M*home-c>=0) {
				answer=Math.max(answer, home);
			}
		}
	}
}//end of class 

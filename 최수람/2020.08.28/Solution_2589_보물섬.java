package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2589_보물섬 {
	static int N,M;
	static char map[][];
	static List<int[]> land;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char [N][M];
		land=new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='L') {
					land.add(new int [] {i,j});
				}
			}
		}
		for(int i=0;i<land.size();i++) {
			bfs(i);
		}
		System.out.println(answer);
	}//end of main
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs(int i) {
		Queue<int []> queue=new LinkedList<>();
		boolean visit[][]=new boolean[N][M];
		int x=land.get(i)[0];
		int y=land.get(i)[1];
		
		queue.add(new int [] {x,y,0});
		visit[x][y]=true;
		while(!queue.isEmpty()) {
			int cur[]=queue.poll();
			answer=Math.max(answer, cur[2]);
			for(int d=0;d<4;d++) {
				int nx=cur[0]+dir[d][0];
				int ny=cur[1]+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!visit[nx][ny]&&map[nx][ny]=='L') {
					visit[nx][ny]=true;
					queue.add(new int [] {nx,ny,cur[2]+1});
				}
			}
		}
	}
}//end of class 

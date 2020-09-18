package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_2665_미로만들기 {
	static int N;
	static int map[][];
	static int dist[][];
	static class Node implements Comparable<Node> {
		public int x;
		public int y;
		public int cnt;
		public Node(int x, int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		dist=new int [N][N];
		for(int i=0;i<N;i++) {
			String st=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=st.charAt(j)-'0';
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(dist[N-1][N-1]);
	}//end of main
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node (0,0,0));
		dist[0][0]=0;
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			int x=cur.x;
			int y=cur.y;
			int cnt=cur.cnt;
			if(x==N-1 && y==N-1) return ;
			if(dist[x][y]<cnt) continue;
			for(int d=0;d<4;d++) {
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(map[nx][ny]==0) {
					if(dist[nx][ny]> cnt+1) {
						dist[nx][ny]=cnt+1;
						pq.add(new Node(nx,ny,dist[nx][ny]));
					}
				}else if(map[nx][ny]==1) {
					if(dist[nx][ny]>cnt) {
						dist[nx][ny]=cnt;
						pq.add(new Node(nx,ny,dist[nx][ny]));
					}
				}
			}
		}
	}
}//end of class 

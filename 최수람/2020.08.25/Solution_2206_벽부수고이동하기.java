package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 현재 map[x][y]에 벽을 뚫고 온건지, 아닌지 구분 시켜야 함 ! 
public class Solution_2206_벽부수고이동하기 {
	static int N,M;
	static int map[][];
	static boolean visit[][][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		visit=new boolean[N][M][2];
		answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(answer==Integer.MAX_VALUE? -1:answer);
	}//end of main
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		int flag;
		public Node(int x,int y,int cost,int flag) {
			this.x=x;
			this.y=y;
			this.cost=cost;
			this.flag=flag;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		visit[0][0][0]=true;
		pq.add(new Node(0,0,1,0));
		
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			if(cur.x==N-1&&cur.y==M-1) {
				answer=Math.min(answer, cur.cost);
				continue;
			}
			if(cur.cost>=answer) {
				continue;
			}
			for(int d=0;d<4;d++) {
				int nx=cur.x+dir[d][0];
				int ny=cur.y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!visit[nx][ny][cur.flag]) {
					if(map[nx][ny]==0) {
						visit[nx][ny][cur.flag]=true;
						pq.add(new Node(nx,ny,cur.cost+1,cur.flag));
					}else if(cur.flag==0&&map[nx][ny]==1) {
						visit[nx][ny][1]=true;
						pq.add(new Node(nx,ny,cur.cost+1,1));
					}
				}
			}
		}
		
	}
}//end of class 

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//악마가 이동하는 길은 수연이 이동할 수 없으므로
//악마를 먼저 퍼뜨리고 수연이 이동해야 함 
public class Solution_7793_오나의여신님 {
	static int N,M;
	static char map[][];
	static int sx,sy;
	static int ex,ey;
	static List<int []> devil;
	static boolean s_visit[][];
	static boolean d_visit[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new char [N][M];
			answer=Integer.MAX_VALUE;
			s_visit=new boolean[N][M];
			d_visit=new boolean[N][M];
			devil=new LinkedList<>();
			for(int i=0;i<N;i++) {
				String str=br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='D') {
						ex=i;
						ey=j;
					}else if(map[i][j]=='S') {
						sx=i;
						sy=j;
					}else if(map[i][j]=='*') {
						devil.add(new int [] {i,j});
					}
				}
			}
			bfs();
			System.out.print("#"+t+" ");
			System.out.println(answer==Integer.MAX_VALUE? "GAME OVER":answer);
		}
	}//end of main
	//수연 이동 
	//악마 퍼지게 
	static class Suyeon implements Comparable<Suyeon>{
		int x;
		int y;
		int d;
		public Suyeon(int x,int y,int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
		@Override
		public int compareTo(Suyeon o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.d, o.d);
		}
	}
	static int dir[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		PriorityQueue<Suyeon> pq=new PriorityQueue<>();
		Queue<int[]> q=new LinkedList<int[]>();
		pq.add(new Suyeon(sx,sy,0));
		s_visit[sx][sy]=true;
		for(int i=0;i<devil.size();i++) {
			int x=devil.get(i)[0];
			int y=devil.get(i)[1];
			q.add(new int [] {x,y});
			d_visit[x][y]=true;			
		}
		
		while(!pq.isEmpty()) {
			int dlen=q.size();
			for(int i=0;i<dlen;i++) {
				int [] dcur=q.poll();
				for(int d=0;d<4;d++) {
					int nx=dcur[0]+dir[d][0];
					int ny=dcur[1]+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(!d_visit[nx][ny]) {
						if(map[nx][ny]!='X'&&map[nx][ny]!='D') {
							d_visit[nx][ny]=true;
							map[nx][ny]='*';
							q.add(new int[] {nx, ny});							
						}
					}
				}				
			}
			int slen=pq.size();
			for(int i=0;i<slen;i++) {
				Suyeon cur=pq.poll();
				if(cur.x==ex&&cur.y==ey) {
					answer=Math.min(answer, cur.d);
					continue;
				}
				if(answer<cur.d) {
					continue;
				}
				for(int d=0;d<4;d++) {
					int nx=cur.x+dir[d][0];
					int ny=cur.y+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(!s_visit[nx][ny]) {
						if(map[nx][ny]!='*'&& map[nx][ny]!='X') {
							s_visit[nx][ny]=true;
							pq.add(new Suyeon(nx, ny, cur.d+1));						
						}
					}
				}
			}
		}
	}
}//end of class 

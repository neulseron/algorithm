import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class V implements Comparable<V>{
	int s;
	int e;
	int len;
	
	public V(int s, int e, int len) {
		super();
		this.s = s;
		this.e = e;
		this.len = len;
	}

	@Override
	public int compareTo(V o) {
		// TODO Auto-generated method stub
		return o.len>=this.len? -1:1;
	}
	
}
public class Solution_17472_다리만들기2 {
	static int N,M,answer;
	static int map[][];
	static boolean check[][];
	static int len[][];
	static int cnt;
	static int parent[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		check=new boolean[N][M];
		answer=0;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		cnt=1;
		//1. 섬구분하기 
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(!check[i][j]&&map[i][j]==1){					
					bfs(i,j,cnt);
					cnt++;
				}
			}
		}
		cnt-=1;
		parent=new int [cnt+1];
		len=new int [cnt+1][cnt+1];
		for (int [] arr : len) {
			Arrays.fill(arr,Integer.MAX_VALUE);
		}
		//2. 경로 연결하기
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]!=0){
						make_bridge(i,j,map[i][j]);
				}
			}
		}
		//3. kruskal 알고리즘으로 풀기 
		PriorityQueue<V> pq=new PriorityQueue<V>();
		for(int i=1;i<=cnt;i++){
			for(int j=1;j<=cnt;j++){
				if(len[i][j]!=Integer.MAX_VALUE){
					pq.add(new V(i,j,len[i][j]));
				}
			}
		}
		for(int i=1;i<=cnt;i++){
			parent[i]=i;
		}
		if(pq.size()<cnt-1){
			answer=-1;
		}else {
			int c=0;
			while(!pq.isEmpty()){
				V cur=pq.poll();
				int s=cur.s;
				int e=cur.e;
				int p1=find(s);
				int p2=find(e);
				if(p1==p2) continue;
				union(s,e);
				parent[p1]=p2;
				answer+=cur.len;
				c++;
			}
			//모든 정점이 연결되어있는지 확인해야함 
			if(c!=cnt-1)
				answer=-1;
		}
		System.out.println(answer);
	}//end of main
	private static void union(int s, int e) {
		int p1=find(s);
		int p2=find(e);
		if(p1!=p2)
			parent[p1]=p2;
		else return;
		
	}
	private static int find(int i) {
		if(parent[i]==i)
			return parent[i];
		return parent[i]=find(parent[i]);
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void make_bridge(int x, int y, int num) {
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			if(map[nx][ny]==0){
				int cnt=0;
				while(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]==0){
					nx+=dir[d][0];
					ny+=dir[d][1];
					cnt++;
				}
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&cnt>1){
					len[num][map[nx][ny]]=len[map[nx][ny]][num]=Math.min(cnt,len[num][map[nx][ny]]);
				}
			}
		}
	}
	private static void bfs(int x,int y,int num) {
		Queue<int []> q=new LinkedList<int[]>();
		check[x][y]=true;
		q.offer(new int [] {x,y});
		map[x][y]=num;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int cx=cur[0];
			int cy=cur[1];
			for(int d=0;d<4;d++){
				int nx=cx+dir[d][0];
				int ny=cy+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!check[nx][ny] && map[nx][ny]==1){
					check[nx][ny]=true;
					map[nx][ny]=num;
					q.offer(new int []{nx,ny});
				}
			}
		}
	}
}//end of class

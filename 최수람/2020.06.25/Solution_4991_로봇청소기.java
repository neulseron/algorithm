

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4991_로봇청소기 {
	static int w,h,size,answer;
	static char map[][];
	static List<int[]> point;
	static int adj[][];
	static int sx,sy;
	static boolean check[];
	static int select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){		
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			h=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			if(h==0&&w==0)
				return;
			map=new char [w][h];
			point=new LinkedList<int[]>();
			answer=Integer.MAX_VALUE;
			for(int i=0;i<w;i++){
				map[i]=br.readLine().toCharArray();
				for(int j=0;j<h;j++){
					if(map[i][j]=='o'){
						sx=i;
						sy=j;
					}
					if(map[i][j]=='*'){
						point.add(new int []{i,j});
					}
				}
			}
			point.add(0, new int []{sx,sy});
			size=point.size();
			adj=new int [size][size];
			//bfs로 인접행렬 만들기 
			for(int i=0;i<size;i++){
				bfs(i);
			}
			//지점들의 순열 만들기 
			check=new boolean[size];
			select=new int [size];
			select[0]=0;
			dfs(1);
			System.out.println(answer==Integer.MAX_VALUE? -1:answer);
		}
	}//end of main
	private static void dfs(int cnt) {
		if(cnt==size){
			//순열대로 방문할 시 총 거리 구하기 
			int sum=0;
			boolean con=true;
			for(int i=0;i<size-1;i++){
				int cur=select[i];
				int next=select[i+1];
				if(adj[cur][next]==0){
					con=false;
					break;
				}
				sum+=adj[cur][next];
			}
			if(!con)
				return;
			if(answer>sum){
				answer=sum;
			}
			return ;
		}
		for(int i=1;i<size;i++){
			if(!check[i]){
				select[cnt]=i;
				check[i]=true;
				dfs(cnt+1);
				check[i]=false;
			}
		}
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs(int start) {
		Queue<int []> queue=new LinkedList<>();
		boolean visit[][]=new boolean[w][h];
		int cx=point.get(start)[0];
		int cy=point.get(start)[1];
		queue.add(new int []{cx,cy,0});
		visit[cx][cy]=true;
		while(!queue.isEmpty()){
			int cur[]=queue.poll();
			int x=cur[0];
			int y=cur[1];
			int cnt=cur[2];
			if(map[x][y]=='*' || map[x][y]=='o'){
				int index=find(x,y);
				adj[start][index]=cnt;
			}
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=w||ny<0||ny>=h) continue;
				if(map[nx][ny]!='x'&&!visit[nx][ny]){
					visit[nx][ny]=true;
					queue.add(new int []{nx,ny,cnt+1});
				}
			}
		}
	}
	private static int find(int x, int y) {
		for(int i=0;i<size;i++){
			if(point.get(i)[0]==x && point.get(i)[1]==y){
				return i;
			}
		}
		return -1;
	}
}//end of class 

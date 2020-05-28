import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17142_연구소3 {
	static int N,M;
	static int map[][];
	static Queue<int []> q;
	static boolean [][]check;
	static List<int []> virus;
	static int count;
	static int answer;
	static int select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N][N];
		answer=Integer.MAX_VALUE;
		select=new int [M];
		virus=new LinkedList<int[]>();
		q=new LinkedList<>();
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2){
					virus.add(new int []{i,j,0});
				}else if(map[i][j]==0){
					count++;
				}
			}
		}
		if(count==0){
			answer=0;
		}else{
			dfs(0,0);			
		}
		System.out.println(answer==Integer.MAX_VALUE? -1:answer);
	}//end of main
	private static void dfs(int idx, int cnt) {
		if(cnt==M){
			//활성화 시킬 M개의 바이러스를 모두 골랐으면, bfs탐색 시작 
			q.clear();
			check=new boolean[N][N];
		//	System.out.println(Arrays.toString(select));
			for(int i=0;i<M;i++){
				int cur[]=virus.get(select[i]);
				q.add(cur);
				check[cur[0]][cur[1]]=true;
			}
			bfs();
			return ;
		}
		for(int i=idx;i<virus.size();i++){
			select[cnt]=i;
			dfs(i+1,cnt+1);
		}
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		int total=count;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			int time=cur[2];
			if(time>answer){ // 이미 최소값보다 더 많이 돌았을떄 
				break ;
			}
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(0<=nx&&nx<N&&0<=ny&&ny<N&&!check[nx][ny]&&map[nx][ny]!=1){
					if(map[nx][ny]==0){
						total--;
						if(total==0){
							answer=Math.min(time+1, answer);
							return ;
						}
					}
					q.add(new int []{nx,ny,time+1});
					check[nx][ny]=true;
				}
			}
		}
	}
}//end of class 

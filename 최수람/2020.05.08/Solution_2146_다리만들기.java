
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2146_다리만들기 {
	static int N,islandIdx,answer;
	static int map[][];

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];

		islandIdx=2;
		answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]==1){
					bfs(i,j);
					islandIdx++;
				}
			}
		}
		for(int i=2;i<islandIdx;i++){
			int num=make_bridge(i);
			System.out.println(num);
			answer=Math.min(answer,num);
		}
		System.out.println(answer);
	} //end of main

	private static int make_bridge(int startnum) {
		Queue<int []> q=new LinkedList<>();
		boolean check[][]=new boolean [N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]==startnum){
					q.add(new int [] {i,j});
					check[i][j]=true;
				}
			}
		}
		int cnt=0;
		while(!q.isEmpty()){
			int qsize=q.size();
			for(int qi=0;qi<qsize;qi++){
				int cur[]=q.poll();
				int x=cur[0];
				int y=cur[1];
				for(int d=0;d<4;d++){
					int nx=x+dir[d][0];
					int ny=y+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(!check[nx][ny]&&map[nx][ny]==0){
						check[nx][ny]=true;
						q.add(new int []{nx,ny});
					}else if(map[nx][ny]!=0 && map[nx][ny]!=startnum){
						return cnt;
					}
				}
			}
			cnt++;
		}
		return 0;
	}

	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs(int i, int j) {
		Queue<int []> queue=new LinkedList<int[]>();
		queue.add(new int []{i,j});
		map[i][j]=islandIdx;
		while(!queue.isEmpty()){
			int cur[]=queue.poll();
			int x=cur[0];
			int y=cur[1];
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(map[nx][ny]==1){
					map[nx][ny]=islandIdx;
					queue.offer(new int []{nx,ny});
				}
			}
		}
	}
}//end of class 

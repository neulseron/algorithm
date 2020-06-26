

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14442_벽부수고이동하기2 {
	static int N,M,K;
	static int map[][];
	static boolean visit[][][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		visit=new boolean[N][M][K+1];
		answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			String str=br.readLine();
			for(int j=0;j<M;j++){
				map[i][j]=str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}//end of main 
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		Queue<int []> queue=new LinkedList<>();
		visit[0][0][K]=true;
		queue.add(new int []{0,0,K,1});
		while(!queue.isEmpty()){
			int cur[]=queue.poll();
			int x=cur[0];
			int y=cur[1];
			int k=cur[2];
			int cnt=cur[3];
			if(x==N-1&&y==M-1){
				answer=Math.min(answer, cnt);
			}
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(map[nx][ny]==0 && !visit[nx][ny][k]){
					visit[nx][ny][k]=true;
					queue.add(new int []{nx,ny,k,cnt+1});
				}
				if(map[nx][ny]==1){
					if(k>0 && !visit[nx][ny][k]){
						visit[nx][ny][k]=true;
						queue.add(new int []{nx,ny,k-1,cnt+1});
					}
				}
			}
		}
		
	}

}//end of class 

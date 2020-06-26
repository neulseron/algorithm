

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1018_체스판_다시_칠하기 {
	static int N,M,answer;
	static char map[][];
	static int R,C;
	static class Node{
		int x;
		int y;
		char color;
		public Node(int x,int y,char color){
			this.x=x;
			this.y=y;
			this.color=color;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		answer=Integer.MAX_VALUE;
		map=new char [N][M];
		for(int i=0;i<N;i++){
			map[i]=br.readLine().toCharArray();
		}
		//보드를 8*8로 나누기 
		if(N==8&&M==8){
			R=7;
			C=7;
			bfs(0,0,'B');
			bfs(0,0,'W');
		}else{
			for(int i=0;i<N;i++){
				if((i+8)-1>=N) continue;
				else{	
					R=(i+8)-1;
					for(int j=0;j<M;j++){
						if((j+8)-1<M){
							C=(j+8)-1;
							bfs(i,j,'B');
							bfs(i,j,'W');
						}
					}
				}
			}
		}
		System.out.println(answer);
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	//다시 칠해야하는 정사각형 개수 세기 
	//color : 0,0의 색상 
	private static void bfs(int i, int j,char color) {
		Queue<Node> queue=new LinkedList<>();
		boolean visit[][]=new boolean [N][M];
		int cnt=0;
		if(map[i][j]!=color) cnt++;
		queue.add(new Node(i,j,color));
		visit[i][j]=true;
		while(!queue.isEmpty()){
			Node cur=queue.poll();
			for(int d=0;d<4;d++){
				int nx=cur.x+dir[d][0];
				int ny=cur.y+dir[d][1];
				if(nx<i||nx>R||ny<j||ny>C) continue;
				if(!visit[nx][ny]){
					visit[nx][ny]=true;
					if(map[nx][ny]==cur.color){
						cnt++;
						if(cur.color=='B'){
							queue.add(new Node(nx,ny,'W'));
						}else{
							queue.add(new Node(nx,ny,'B'));
						}
					}else{
						queue.add(new Node(nx,ny,map[nx][ny]));
					}
				}
			}
		}
		answer=Math.min(answer, cnt);
	}
}//end of class 

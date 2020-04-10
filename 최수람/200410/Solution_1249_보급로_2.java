
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_1249_보급로_2 {
	static int map[][],dist[][];
	static int N;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("1249_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine());
			map=new int [N][N];
			String  str=null;
			for(int i=0;i<N;i++){
				str=br.readLine();
				for(int j=0;j<N;j++){
					map[i][j]=str.charAt(j)-'0';
				}
			}
			solution();
			System.out.println("#"+t+" "+dist[N-1][N-1]);			
		}
	}//end of main 
	static int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
	private static void solution() {
		// TODO Auto-generated method stub
		PriorityQueue<int []> pq=new PriorityQueue<>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		boolean check[][]=new boolean[N][N];
		dist=new int [N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0]=0;
		pq.offer(new int [] {0,0,dist[0][0]});
		check[0][0]=true;
		while(!pq.isEmpty()){
			int [] cur=pq.poll();
			int x=cur[0];
			int y=cur[1];
			if(x==N-1 && y==N-1){
				return;
			}
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(check[nx][ny]) continue;
				if(dist[nx][ny]>dist[x][y]+map[nx][ny]){
					dist[nx][ny]=dist[x][y]+map[nx][ny];
					pq.offer(new int []{nx,ny,dist[nx][ny]});
				}
			}
			check[x][y]=true;
		}
	}
}//end of class

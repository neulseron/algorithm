
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution_1227_미로2 {
	static int map[][];
	static int sx,sy,dx,dy;
	static final int N=100;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("1227_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++){
			int tc=Integer.parseInt(br.readLine().trim());
			map=new int [N][N];
			String str=null;
			for(int i=0;i<N;i++){
				str=br.readLine();
				for(int j=0;j<N;j++){
					map[i][j]=str.charAt(j)-'0';
					if(map[i][j]==2){
						sx=i;
						sy=j;
					}else if(map[i][j]==3){
						dx=i;
						dy=j;
					}
				}
			}
			int res=bfs();
			System.out.println("#"+tc+" "+res);
		}
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static int bfs() {
		boolean check[][]=new boolean[N][N];
		Queue<int []>q=new LinkedList<int[]>();
		q.add(new int [] {sx,sy});
		check[sx][sy]=true;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0 || nx>=N || ny<0|| ny>=N) continue;
				if(map[nx][ny]==3){
					return 1;
				}
				if(!check[nx][ny] && map[nx][ny]==0){
					q.add(new int [] {nx,ny});
					check[nx][ny]=true;
				}
			}
		}
		return 0;
	}
}//end of class 

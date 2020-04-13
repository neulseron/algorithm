
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N,answer;
	static char[][]map;
	static int dir[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	static Queue<int []> q;
	static boolean check[][];
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("1868_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine());
			map=new char[N][N];
			answer=0;
			q=new LinkedList<>();
			check=new boolean[N][N];
			for(int i=0;i<N;i++){
				map[i]=br.readLine().toCharArray();
			}
			for(int x=0;x<N;x++){
				for(int y=0;y<N;y++){
					if(map[x][y]=='.'){
						boolean zero=true;
						for(int d=0;d<8;d++){
							int nx=x+dir[d][0];
							int ny=y+dir[d][1];
							if(nx<0||nx>=N||ny<0||ny>=N) continue;
							if(map[nx][ny]=='*'){
								zero=false;
								break;
							}
						}
						if(zero){
							q.add(new int []{x,y});
							solution();
							answer++;
						}
					}
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j]=='.')
						answer++;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	private static void solution() {
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			boolean zero=true;
			for(int d=0;d<8;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(map[nx][ny]=='*'){
					zero=false;
					break;
				}
			}
			if(zero){
				map[x][y]='X';
				for(int d=0;d<8;d++){
					int nx=x+dir[d][0];
					int ny=y+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(!check[nx][ny]&&map[nx][ny]=='.'){
						q.add(new int [] {nx,ny});
						check[nx][ny]=true;
					}
				}
			}else{
				map[x][y]='X';
			}
		}
	}
}//end of class 

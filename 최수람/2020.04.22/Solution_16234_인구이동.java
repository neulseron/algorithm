import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16234_인구이동 {
	static int N,L,R;
	static int map[][];
	static boolean check[][];
	static int copymap[][];
	static List<int []> unit;
	static boolean con;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int [N][N];
		copymap=new int [N][N];
		check=new boolean[N][N];
		unit=new LinkedList<>();
		con=false;
		int answer=0;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				copymap[i][j]=map[i][j];
			}
		}
		while(true){
			con=false;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!check[i][j]){
						unit.clear();
						bfs(i,j);
					}
				}
			}
			if(!con)
				break;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					map[i][j]=copymap[i][j];
				}
			}
			for(int i=0;i<N;i++){
				Arrays.fill(check[i], false);				
			}
			answer++;
		}
//		for(int i=0;i<N;i++){
//			System.out.println(Arrays.toString(copymap[i]));
//		}
		System.out.println(answer);
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs(int i, int j) {
		Queue<int []> q=new LinkedList<int[]>();
		q.add(new int []{i,j});
		check[i][j]=true;
		unit.add(new int [] {i,j});
		int sum=map[i][j];
		int cnt=1;
		while(!q.isEmpty()){
			int cur[]=q.poll();
			int x=cur[0];
			int y=cur[1];
			for(int d=0;d<4;d++){
				int nx=x+dir[d][0];
				int ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(check[nx][ny]) continue;
				int cha=Math.abs(map[x][y]-map[nx][ny]);
				if(L<=cha && cha<=R){
					sum+=map[nx][ny];
					cnt++;
					unit.add(new int []{nx,ny});
					check[nx][ny]=true;
					q.add(new int [] {nx,ny});
				}
			}
		}
		if(unit.size()>1){
			con=true;
			for(int k=0;k<unit.size();k++){
				int x=unit.get(k)[0];
				int y=unit.get(k)[1];
				copymap[x][y]=sum/cnt;
			}
		}		
	}
}

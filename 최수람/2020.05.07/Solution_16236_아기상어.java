
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16236_아기상어 {
	static class Shark{
		int size;
		int eat;
		public Shark(int size,int eat){
			this.size=size;
			this.eat=eat;
		}
	}
	static class Fish implements Comparable<Fish>{
		int cnt;
		int x;
		int y;
		public Fish(int cnt,int x,int y){
			this.cnt=cnt;
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.cnt==o.cnt){
				if(this.x==o.x)
					return Integer.compare(this.y, o.y);
				else
					return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	static Shark shark;
	static int N,sx,sy;
	static int map[][];
	static int answer;
	static List<Fish> fishes;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int [N][N];
		StringTokenizer st=null;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9){
					sx=i;
					sy=j;
				}
			}
		}
		shark=new Shark(2, 0);
		fishes=new LinkedList<>();
		solution();
		System.out.println(answer);
	}//end of main
	private static void solution() {
		while(true){
			//1. 먹을 수 있는 물고기 있는지 탐색 
			fishes.clear();
			bfs();
			//더 이상 먹을 수 있는 물고기가 없다면 
			if(fishes.size()==0){
				return;
			}
			//2. 먹으러 이동	
			Collections.sort(fishes);
			Fish fish=fishes.get(0);
			sx=fish.x;
			sy=fish.y;
			shark.eat++;
			answer+=fish.cnt;
			if(shark.eat==shark.size){
				shark.size++;
				shark.eat=0;
			}
		}
		
	}
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void bfs() {
		Queue<int []> q=new LinkedList<int[]>();
		boolean check[][]=new boolean [N][N];
		map[sx][sy]=0;
		check[sx][sy]=true;
		q.add(new int [] {sx,sy});
		int cnt=0;
		while(!q.isEmpty()){
			int qsize=q.size();
			cnt++;
			for(int qi=0;qi<qsize;qi++){
				int cur[]=q.poll();
				int cx=cur[0];
				int cy=cur[1];
				for(int d=0;d<4;d++){
					int nx=cx+dir[d][0];
					int ny=cy+dir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(!check[nx][ny]){						
						//먹지는 못하고 이동만 가능
						if(map[nx][ny]==0||map[nx][ny]==shark.size){
							check[nx][ny]=true;
							q.add(new int []{nx,ny});
						}else if(map[nx][ny]!=0 && map[nx][ny]<shark.size){
							//먹을 수 있음 
							check[nx][ny]=true;
							q.add(new int []{nx,ny});
							fishes.add(new Fish(cnt, nx, ny));
						}else continue;
					}
				}
			}
		}
		
	}
}//end of class 

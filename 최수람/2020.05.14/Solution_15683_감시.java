
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_15683_감시 {
	static int N,M,answer;
	static char map[][];
	static class CCTV{
		int x;
		int y;
		int type;
		int rotate;
		public CCTV(int x,int y,int type){
			this.x=x;
			this.y=y;
			this.type=type;
			if(type==1){
				this.rotate=4;
			}else if(type==2){
				this.rotate=2;
			}else if(type==3){
				this.rotate=4;
			}else if(type==4){
				this.rotate=4;
			}else if(type==5){
				this.rotate=1;
			}
		}
	}
	static List<CCTV> cctv;
	static List<int [][]> cctvdir;
	static int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char [N][M];
		answer=Integer.MAX_VALUE;
		cctv=new LinkedList<>();
		cctvdir=new LinkedList<>();
		cctvdir.add(new int [][]{{0},{1},{2},{3}});
		cctvdir.add(new int [][]{{0,1},{2,3}});
		cctvdir.add(new int [][]{{0,2},{0,3},{1,2},{1,3}});
		cctvdir.add(new int [][]{{1,2,3},{0,2,3},{0,1,3},{0,1,2}});
		cctvdir.add(new int [][]{{0,1,2,3}});
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=st.nextToken().charAt(0);
				if('1'<=map[i][j]&&map[i][j]<='5'){
					cctv.add(new CCTV(i,j,map[i][j]-'0'));
				}
			}
		}
		dfs(0,map);
		System.out.println(answer);
	}//end of main
	private static void dfs(int idx,char[][] map) {
		if(idx==cctv.size()){
			answer=Math.min(answer,countMap(map));
			return ;
		}
		
		for(int d=0;d<cctv.get(idx).rotate;d++){
			char newmap[][]=move(cctv.get(idx),d,map);
		//	printMap(newmap);
			dfs(idx+1,newmap);
		}
	}
	private static void printMap(char[][] newmap) {
		for(int i=0;i<N;i++){
			System.out.println(Arrays.toString(newmap[i]));
		}
		
	}
	private static char[][] move(CCTV curcctv, int d, char[][] map) {
		char newmap[][]=copyMap(map);
		int mydir[]=cctvdir.get(curcctv.type-1)[d];
		int nx,ny;
		for(int i=0;i<mydir.length;i++){
			int x=curcctv.x;
			int y=curcctv.y;
			int curd=mydir[i];
			while(true){
				nx=x+dir[curd][0];
				ny=y+dir[curd][1];
				if(nx<0||nx>=N||ny<0||ny>=M) break;
				if(newmap[nx][ny]=='6') break;
				if(newmap[nx][ny]=='0'){
					newmap[nx][ny]='#';
				}
				x=nx;
				y=ny;
			}
		}
		return newmap;
	}
	private static char[][] copyMap(char[][] map) {
		char newmap[][]=new char[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				newmap[i][j]=map[i][j];
			}
		}
		return newmap;
	}
	private static int countMap(char[][] map) {
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]=='0'){
					cnt++;
				}
			}
		}
		return cnt;
	}
}//end of class 

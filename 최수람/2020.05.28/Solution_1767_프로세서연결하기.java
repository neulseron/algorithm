import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int N,preconnect;
	static int map[][];
	static List<int []> core;
	static int maxcore;
	static int minlen[];
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine());
			map=new int [N][N];
			core=new LinkedList<int[]>();
			preconnect=0;
			minlen=new int [12];
			Arrays.fill(minlen,Integer.MAX_VALUE);
			maxcore=0;
			StringTokenizer st=null;
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1){
						//가장자리에 있는 경우 
						if(i==0||i==N-1||j==0||j==N-1){
							preconnect++; // 이미 연결 
						}else{
							//가장자리에 있지 않음 
							core.add(new int []{i,j});
							
						}
						
					}
				}
			}
			cnt=core.size();
			dfs(0,0,0,map);
			System.out.println("#"+t+" "+minlen[maxcore]);
		}
	}//end of main
	static int dir [][] ={{-1,0},{1,0},{0,-1},{0,1}};
	private static void dfs(int idx, int connect, int len, int[][] curmap) {
		if(idx==cnt){
			if(maxcore<connect){
				maxcore=connect;
			}else if(maxcore==connect){
				minlen[maxcore]=Math.min(minlen[maxcore], len);
			}
			return ;
		}
		for(int d=0;d<4;d++){
			boolean con=true;
			int sum=0;
			int newmap[][]=copyMap(curmap);
			int x=core.get(idx)[0];
			int y=core.get(idx)[1];
			int nx,ny;
			while(true){
				nx=x+dir[d][0];
				ny=y+dir[d][1];
				if(nx<0||nx>=N||ny<0||ny>=N){
					break;
				}else{
					if(newmap[nx][ny]!=0){
						con=false;
						break;
					}else{
						newmap[nx][ny]=2;
						sum++;
					}
				}
				x=nx;
				y=ny;
			}
			if(con){
				dfs(idx+1,connect+1,len+sum,newmap); // 연결 가능한 경우 
			}
		}
		dfs(idx+1,connect,len,map);// 연결안해보는 경우 추가 
	}
	private static int[][] copyMap(int[][] curmap) {
		int newmap[][]=new int [N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				newmap[i][j]=curmap[i][j];
			}
		}
		return newmap;
	}
}//end of class 

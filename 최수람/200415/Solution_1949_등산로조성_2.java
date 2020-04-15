import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성_2 {
	static int N,K,answer;
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("1949_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			int highest=0;
			answer=0;
			map=new int [N][N];
			visit=new boolean [N][N];
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
					highest=Math.max(highest,map[i][j]);
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j]==highest){
						visit[i][j]=true;
						dfs(i,j,false,1);
						visit[i][j]=false;
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void dfs(int x, int y,boolean k,int len) {
		boolean con=false;
		for(int d=0;d<4;d++){
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=N) continue;
			if(visit[nx][ny]) continue;
			if(map[nx][ny]>=map[x][y]){
				if(!k){
					for(int i=1;i<=K;i++){
						if(map[nx][ny]-i<map[x][y]){
							visit[nx][ny]=true;
							map[nx][ny]-=i;
							con=true;
							dfs(nx,ny,true,len+1);
							map[nx][ny]+=i;
							visit[nx][ny]=false;
						}
					}
				}
			}else{
				visit[nx][ny]=true;
				con=true;
				dfs(nx,ny,k,len+1);
				visit[nx][ny]=false;
			}
		}
		if(!con){
			//System.out.println(x+" "+y+" "+map[x][y]+" "+len);
			answer=Math.max(answer, len);
			return;
		}
	}
}//end of class 

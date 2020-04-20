import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int N,W,H,answer;
	static int [][] map;
	static boolean [][] visit;
	static int blocks; //처음 벽돌의 수 
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("5656_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			map=new int [H][W];
			visit=new boolean[H][W];
			answer=Integer.MAX_VALUE;
			blocks=0;
			for(int i=0;i<H;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<W;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]!=0)
						blocks++;
				}
			}
			for(int i=0;i<W;i++){
				dfs(0,i,blocks,map);
			}
			System.out.println("#"+tc+" "+answer);
		}
	}//end of main
	static int [][] dir={{-1,0},{1,0},{0,1},{0,-1}};
	private static void dfs(int cnt,int col,int b,int [][]copy) {
		if(cnt==N){
			//남은 벽돌 개수 세기
			answer=Math.min(b, answer);			
			return ;
		}
		//배열 초기화 
		int tmp[][]=new int [H][W];
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				tmp[i][j]=copy[i][j];
			}
		}
		//구슬 이동 (벽돌 마주칠때 까지)
		int index=-1;
		for(int i=0;i<H;i++){
			if(tmp[i][col]!=0){
				index=i;
				break;
			}
		}
		int sum=0;
		//깨뜨릴 벽돌이 있는 경우 
		if(index!=-1){
			LinkedList<int[]> q=new LinkedList<>();
			q.offer(new int [] {index,col});
			for (boolean[] v : visit) {				
				Arrays.fill(v, false);
			}
			visit[index][col]=true;
			while(!q.isEmpty()){
				int cur[]=q.poll();
				int x=cur[0];
				int y=cur[1];
				int num=tmp[x][y];
				if(num==0) continue;
				sum++;
				tmp[x][y]=0;
				if(num>1){
					for(int d=0;d<4;d++){
						int tx=x;
						int ty=y;
						for(int it=1;it<num;it++){
							int nx=tx+dir[d][0];
							int ny=ty+dir[d][1];
							if(0>nx ||nx>=H||0>ny||ny>=W)break;
							if(!visit[nx][ny]){
								visit[nx][ny]=true;
								q.offer(new int []{nx,ny});
							}
							tx=nx;
							ty=ny;							
						}
					}
				}
			}
			for(int i=0;i<W;i++){
				int j1,n=1;
				for(j1=H-1;j1>=0;j1--){
					if(tmp[j1][i]==0) break;
				}
				if(j1<=0) continue;
				for(int j2=j1-1;j2>=0;j2--){
					if(tmp[j2][i]==0) n++;
					if(tmp[j2][i]!=0){
							tmp[j2+n][i]=tmp[j2][i];
							tmp[j2][i]=0;							
					}
				}
			}
		}//end of col
		for(int i=0;i<W;i++){
			dfs(cnt+1,i,b-sum,tmp);
		}
	}
}//end of class

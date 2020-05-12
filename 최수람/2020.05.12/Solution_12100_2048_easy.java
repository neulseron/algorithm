
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_12100_2048_easy {
	static int N;
	static int map[][],newmap[][];
	static boolean check[][];
	static int answer=0;
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int [N][N];
		newmap=new int [N][N];
		check=new boolean[N][N];
		for(int i=0;i<N;i++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,map);
		System.out.println(answer);
	}//end of main
	private static void dfs(int cnt,int [][]board) {
		if(cnt==5){
			return;
		}
		int nextmap[][]=new int [N][N];
		for(int di=0;di<4;di++){
			answer=Math.max(move(di,board),answer);
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					nextmap[i][j]=newmap[i][j];
				}
			}
			dfs(cnt+1,nextmap);
		}
	}
	private static int move(int di,int [][]board) {
		int max=0;
		for(int i=0;i<N;i++){
			Arrays.fill(newmap[i], 0);
			Arrays.fill(check[i], false);
		}
		boolean check[][]=new boolean[N][N];
		switch(di){
		case 0:
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(board[i][j]!=0)
						max=Math.max(merge(i,j,0,board[i][j]),max);
				}
			}
			break;
		case 1:
			for(int i=N-1;i>=0;i--){
				for(int j=0;j<N;j++){
					if(board[i][j]!=0)
						max=Math.max(merge(i,j,1,board[i][j]),max);
				}
			}
			break;
		case 2:
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(board[i][j]!=0)
						max=Math.max(merge(i,j,2,board[i][j]),max);
				}
			}
			break;
		case 3:
			for(int i=0;i<N;i++){
				for(int j=N-1;j>=0;j--){
					if(board[i][j]!=0)
						max=Math.max(merge(i,j,3,board[i][j]),max);
				}
			}
			break;
		}
		return max;
	}
	private static int merge(int i, int j,int di,int num) {
		int ni=0,nj=0;
		while(true){
			ni=i+dir[di][0];
			nj=j+dir[di][1];
			if(ni<0||ni>=N||nj<0||nj>=N){
				ni-=dir[di][0];
				nj-=dir[di][1];
				newmap[ni][nj]=num;
				break;
			}else if(newmap[ni][nj]!=0){
				if(newmap[ni][nj]==num){
					if(!check[ni][nj]){
						check[ni][nj]=true;
						newmap[ni][nj]+=num;
						break;
					}
					ni-=dir[di][0];
					nj-=dir[di][1];
					newmap[ni][nj]=num;
					break;
				}else{
					ni-=dir[di][0];
					nj-=dir[di][1];
					newmap[ni][nj]=num;
					break;
				}
			}else if(newmap[ni][nj]==0){
				i=ni;
				j=nj;
			}
		}
		return newmap[ni][nj];
	}
}//end of class 

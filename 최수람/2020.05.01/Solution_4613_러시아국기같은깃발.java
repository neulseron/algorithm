import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발 {
	static int N,answer;
	static int change[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			answer=Integer.MAX_VALUE;
			int M=Integer.parseInt(st.nextToken());
			char flag[][]=new char[N][M];
			for(int i=0;i<N;i++){
				flag[i]=br.readLine().toCharArray();
			}
			//0 : W  1 : B  2 : R
			change=new int [N][3];
			int first=0;
			int last=0;
			for(int i=0;i<N;i++){
				int w=0,b=0,r=0;
				for(int j=0;j<M;j++){
					if(i==0){
						if(flag[i][j]=='W')
							first++;
					}else if(i==N-1){
						if(flag[i][j]=='R')
							last++;
					}else{
						switch (flag[i][j]) {
						case 'W':
							w++;
							break;
						case 'B':
							b++;
							break;
						case 'R':
							r++;
							break;
						}
					}
				}
				if(i==0){
					first=M-first;
				}else if(i==N-1){
					last=M-last;
				}else {
					change[i][0]=M-w;
					change[i][1]=M-b;
					change[i][2]=M-r;
				}
			}
			dfs(1,1,0,1,0,0);
//			System.out.println(first+" "+last);
//			for (int[] cs : change) {
//				System.out.println(Arrays.toString(cs));
//			}
			answer+=(first+last);
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	/**
	 * 
	 * @param row : 얼마나 진행했는지 
	 * @param white : 현재까지 흰색 row의 갯수
	 * @param blue : 현재까지 파란색 row의 갯수 
	 * @param red : 현재까지 빨간색 row의 갯수 
	 * @param color : 색상범위 
	 * @param cnt : 현재까지 새로 칠해야하는 칸의 갯수 
	 */
	private static void dfs(int row,int white,int blue,int red, int color, int cnt) {
		if(row==N-1){
			answer=Math.min(answer, cnt);
			return;
		}
		int end=3;
		if(blue==0){
			end=2;
		}
		if(blue==0 && ((N-1)-row)<=1){
			dfs(row+1,white,blue+1,red,1,cnt+change[row][1]);
		}else{
			for(int i=color;i<end;i++){
				if(i==0){
					dfs(row+1,white+1,blue,red,0,cnt+change[row][0]);
				}else if(i==1){
					dfs(row+1,white,blue+1,red,1,cnt+change[row][1]);
				}else if(i==2){
					dfs(row+1,white,blue,red+1,2,cnt+change[row][2]);
				}
			}	
		}
	}
}//end of class

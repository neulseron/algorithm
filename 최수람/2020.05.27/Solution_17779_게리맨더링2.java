
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_17779_게리맨더링2 {
	static int N,totalsum;
	static int map[][];
	static boolean check[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N+1][N+1];
		answer=Integer.MAX_VALUE;
		StringTokenizer st=null;
		for(int i=1;i<=N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				totalsum+=map[i][j];			
			}
		}
		for(int i=1;i<=N-2;i++){
			for(int j=2;j<=N-1;j++){
				check=new boolean [N][N];				
				dfs(i,j,1,1);
			}
		}
		System.out.println(answer);
	}//end of main
	private static void dfs(int x,int y,int d1,int d2) {
		if(d1>=N || d2>=N){
			return ;
		}
		if(check[d1][d2]){
			return ;
		}
		check[d1][d2]=true;
		int x1=x+d1;
		int y1=y-d1;
		int x2=x+d2;
		int y2=y+d2;
		int x3=x+d1+d2;
		int y3=y+d2-d1;
		//네 점 모두 범위 안에 있는지 확인 
		if(1<=x1&&x1<=N&&1<=y1&&y1<=N){
			if(1<=x2&&x2<=N&&1<=y2&&y2<=N){
				if(1<=x3&&x3<=N&&1<=y3&&y3<=N){
						count(x,y,d1,d2);
						dfs(x,y,d1+1,d2);
						dfs(x,y,d1,d2+1);
				}
			}
		}
	}
	private static void count(int x,int y,int d1,int d2) {
		//각 선거구의 인구수를 세는 함수 
		int sum=0;
		int total=0;
		int max=0;
		int min=Integer.MAX_VALUE;
		//1번 선거구 인구수 세기 
		for(int r=1;r<x;r++){
			for(int c=1;c<=y;c++){
				sum+=map[r][c];
			}
		}
		for(int r=0;r<d1;r++){
			for(int c=1;c<y-r;c++){
				sum+=map[x+r][c];
			}
		}
		max=Math.max(max, sum);
		min=Math.min(min, sum);
		total+=sum;
		sum=0;
		//2번 선거구 인구수 세기
		for(int r=1;r<=x;r++){
			for(int c=y+1;c<=N;c++){
				sum+=map[r][c];
			}
		}
		for(int r=1;r<=d2;r++){
			for(int c=y+1+r;c<=N;c++){
				sum+=map[x+r][c];
			}
		}
		max=Math.max(max, sum);
		min=Math.min(min, sum);
		total+=sum;
		sum=0;
		//3번 선거구 인구수 세기
		for(int r=x+d1,i=0;r<x+d1+d2;r++,i++){
			for(int c=1;c<y-d1+i;c++){
				sum+=map[r][c];
			}
		}
		
		for(int r=x+d1+d2;r<=N;r++){
			for(int c=1;c<y-d1+d2;c++){
				sum+=map[r][c];
			}
		}
		max=Math.max(max, sum);
		min=Math.min(min, sum);
		total+=sum;
		sum=0;
		//4번 선거구 인구수 세기 
		for(int r=1;r<=d1;r++){
			for(int c=y+d2-(r-1);c<=N;c++){
				sum+=map[x+d2+r][c];
			}
		}
		for(int r=x+d1+d2+1;r<=N;r++){
			for(int c=y+d2-d1;c<=N;c++){
				sum+=map[r][c];
			}
		}
		max=Math.max(max, sum);
		min=Math.min(min, sum);
		total+=sum;
		//나머지 (5번 선거구) 인구수 세기 
		max=Math.max(max, totalsum-total);
		min=Math.min(min, totalsum-total);
		answer=Math.min(answer,max-min);
		
	}

}//end of class 

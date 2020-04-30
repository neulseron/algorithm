//내가 생각한 아이디어 : 자르는 기준 정하고 가로 세로 모든 경우로 잘라봄 
//				   조각이 n*m이 될때 최소값으로 갱신하기  -> 시간초과 &조각 구하는과정이 애매 
//
//풀이 참고  -> 완전 탐색 : 최초 비용 + 각각의 조각의 비용의 합 --> 최소가 되는 경우 찾기 => 시간 초과 ! 
//		    (+) 메모이제이션 		    
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도 {
	static int N,M,answer;
	static int map[][];
	static int [][][][] memo; // 좌표의 x값 , 좌표의 y값, width, height
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new int [N][M];
			memo=new int [N+1][M+1][N+1][M+1];
			for(int [][][] m1 : memo){
				for(int [][] m2 :m1){
					for(int [] m3 :m2){
						Arrays.fill(m3, Integer.MAX_VALUE);
					}
				}
			}
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//사이즈를 매개변수로 넘김 
			answer=dfs(0,0,N,M);
			System.out.println("#"+tc+" "+answer);
		}
	} //end of main
	//비용을 반환
	private static int dfs(int x, int y, int w, int h) {
		//종료 (단일 블록일때)
		if(w==1 && h==1){
			return 0;
		}
		//이미 계산했으면 
		if(memo[x][y][w][h]!=Integer.MAX_VALUE){
			return memo[x][y][w][h];
		}
		//실행
		int sum=0;
		for(int i=x; i<x+w;i++){
			for(int j=y;j<y+h;j++){
				sum+=map[i][j];
			}
		}
		//가로로 나누어서 최소비용 구하기 
		for(int i=1;i<w;i++){
			//i를 기준으로 위쪽 비용
			memo[x][y][i][h]=dfs(x,y,i,h);
			//i를 기준으로 아래쪽 비용 
			memo[x+i][y][w-i][h]=dfs(x+i,y,w-i,h);
			int sum3=sum+memo[x][y][i][h]+memo[x+i][y][w-i][h];
			memo[x][y][w][h]=Math.min(memo[x][y][w][h], sum3);
		}
		//세로로 나누어서 최소비용 구하기
		for(int i=1;i<h;i++){
			memo[x][y][w][i]=dfs(x,y,w,i);
			memo[x][y+i][w][h-i]=dfs(x,y+i,w,h-i);
			int sum3=sum+memo[x][y][w][i]+memo[x][y+i][w][h-i];
			memo[x][y][w][h]=Math.min(memo[x][y][w][h], sum3);
		}
		//재귀호출 
		return memo[x][y][w][h];
	}
}//end of class 

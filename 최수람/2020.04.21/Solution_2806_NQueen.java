
import java.util.Arrays;
import java.util.Scanner;

public class Solution_2806_NQueen {

	static int N;
	static int board[];
	static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int testcase=1;testcase<=T;testcase++) {
			N=sc.nextInt();
			board=new int [N];
			dfs(0);
			System.out.println("#"+testcase+" "+answer);
			answer=0;
		}
	}
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			answer++;
			return ;
		}
		for(int i=0;i<N;i++){
			boolean isPossible=true;
			for(int j=0;j<cnt;j++){
				if(board[j]==i||Math.abs(j-cnt)==Math.abs(board[j]-i)){
					isPossible=false;
					break;
				}
			}
			if(isPossible){
				board[cnt]=i;
				dfs(cnt+1);
			}
		}
	}
}

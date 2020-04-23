import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_dp {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			int in[][]=new int [N+1][2];
			for(int i=1;i<=N;i++){
				st=new StringTokenizer(br.readLine()," ");
				in[i][0]=Integer.parseInt(st.nextToken());
				in[i][1]=Integer.parseInt(st.nextToken());
			}
			int memo[][]=new int[N+1][L+1];
			for(int i=1;i<=N;i++){
				for(int j=1;j<=L;j++){
					if(j<in[i][1]){
						memo[i][j]=memo[i-1][j];
					}else{
						memo[i][j]=Math.max(memo[i-1][j-in[i][1]]+in[i][0],memo[i-1][j]);
					}
				}
			}
			System.out.println("#"+t+" "+memo[N][L]);
		}
	}//end of main
}//end of class

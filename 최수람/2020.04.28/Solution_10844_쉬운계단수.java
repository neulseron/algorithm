import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		int dp[][]=new int [N+1][10];
		for(int i=1;i<=9;i++){
			dp[1][i]=1;
		}
		for(int n=2;n<=N;n++){
			for(int i=0;i<=9;i++){
				if(i==0){
					dp[n][i]=dp[n-1][1]%1000000000;
				}else if(1<=i&&i<=8){
					dp[n][i]=(dp[n-1][i-1]+dp[n-1][i+1])%1000000000;
				}else if(i==9){
					dp[n][i]=dp[n-1][8]%1000000000;
				}
			}
		}
		int answer=0;
		for(int i=0;i<=9;i++){
			answer=(answer+dp[N][i]) %1000000000;
		}
		System.out.println(answer%1000000000);
	}//end of main
}//end of class

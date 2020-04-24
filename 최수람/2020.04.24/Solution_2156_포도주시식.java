import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2156_포도주시식 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		int nums[]=new int [N+1];
		int dp[]=new int [N+1];
		for(int i=1;i<=N;i++){
			nums[i]=Integer.parseInt(br.readLine().trim());
		}
		dp[1]=nums[1];
		if(N>=2){
			dp[2]=dp[1]+nums[2];
			for(int i=3;i<=N;i++){
				dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+nums[i], dp[i-3]+nums[i-1]+nums[i]));
			}
		}			
		System.out.println(dp[N]);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		int nums[]=new int [N+1];
		int dp[]=new int [N+1];
		int sum=0;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
			nums[i]=Integer.parseInt(st.nextToken());
		}
		dp[1]=nums[1];
		sum=dp[1];
		for(int i=2;i<=N;i++){
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			if(sum<dp[i]){
				sum=dp[i];
			}
		}
		System.out.println(sum);
	}//end of main
}//end of class

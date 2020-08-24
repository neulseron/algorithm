package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_13301_타일장식물 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long memo[]=new long[N+3];
		memo[1]=1;
		memo[2]=1;
		for(int i=3;i<=N+2;i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		System.out.println(memo[N+2]*2);
		
	}//end of main
}//end of class 

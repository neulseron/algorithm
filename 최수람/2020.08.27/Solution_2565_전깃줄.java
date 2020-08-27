package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_2565_전깃줄 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int line[][]=new int [N+1][2];
		int dp[]=new int [N+1];
		StringTokenizer st=null;
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			line[i][0]=Integer.parseInt(st.nextToken());
			line[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int answer=0;
		for(int i=1;i<=N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(line[i][1]>line[j][1]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					answer=Math.max(answer, dp[i]);
				}
			}
		}
		System.out.println(N-answer);
	}//end of main
}//end of class 

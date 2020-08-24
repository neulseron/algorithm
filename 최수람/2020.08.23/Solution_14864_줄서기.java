package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14864_¡Ÿº≠±‚ {
	static int N,M;
	static int nums[];
	static boolean visit[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int [N];
		visit=new boolean[N+1];
		for(int i=0;i<N;i++) {
			nums[i]=i+1;
		}
		for(int i=0;i<M;i++) {
			int x,y;
			st=new StringTokenizer(br.readLine()," ");
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			nums[x-1]++;
			nums[y-1]--;
		}
		boolean con=true;
		for(int i=0;i<N;i++) {
			if(nums[i]<0||nums[i]>N) {
				con=false;
			}
			else if(visit[nums[i]]) {
				con=false;
			}
			visit[nums[i]]=true;
		}
		if(!con) {
			System.out.println(-1);
		}else {
			for(int i=0;i<N;i++) {
				System.out.print(nums[i]+" ");
			}
		}
	}//end of main
}//end of class 

package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13300_πÊπË¡§ {
	static int N,K;
	static int stu[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		stu=new int [7][2];
		int answer=0;
		for(int i=0;i<N;i++) {
			int s,y;
			st=new StringTokenizer(br.readLine()," ");
			s=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			stu[y][s]++;
		}
		for(int i=1;i<7;i++) {
			for(int j=0;j<2;j++) {
				if(stu[i][j]==0) continue;
				if(stu[i][j]%K==0) {
					answer+=stu[i][j]/K;
				}else {
					answer+=stu[i][j]/K+1;
				}
			}
		}
		System.out.println(answer);
	}//end of main
}//end of class 

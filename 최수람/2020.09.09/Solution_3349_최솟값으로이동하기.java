package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3349_최솟값으로이동하기 {
	static int W,H,N;
	static int des[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			des=new int [N][2];
			answer=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine()," ");
				des[i][0]=Integer.parseInt(st.nextToken());
				des[i][1]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N-1;i++) {
				int dx=des[i+1][0]-des[i][0];
				int dy=des[i+1][1]-des[i][1];
				//두 점 사이에 대각선 길이 있는 경우
				if(dx*dy>0) {
					int ads_dx=Math.abs(dx);
					int ads_dy=Math.abs(dy);
					int cha=Math.abs(ads_dx-ads_dy);
					answer+=Math.min(ads_dx,ads_dy)+cha;
				}
				//두 점 사이에 대각선 길이 없는 경우
				else {
					answer+=(Math.abs(dx)+Math.abs(dy));
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
}//end of class 

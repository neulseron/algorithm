
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7227_사랑의카운슬러 {
	static int N;
	static long answer;
	static int xy[][];
	static boolean select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine().trim());
			xy=new int [N][2];
			answer=Long.MAX_VALUE;
			select=new boolean [N];
			StringTokenizer st=null;
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine().trim()," ");
				xy[i][0]=Integer.parseInt(st.nextToken());
				xy[i][1]=Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	private static void combi(int cnt,int start) {
		if(cnt==N/2){
			int s[]=new int [N/2];
			int u[]=new int [N/2];
			int sindex=0;
			int uindex=0;
			for(int i=0;i<N;i++){
				if(select[i]){
					s[sindex]=i;
					sindex++;
				}
				else{
					u[uindex]=i;
					uindex++;
				}
			}
			long x=0,y=0;
			for(int i=0;i<N/2;i++){
				int snum=s[i];
				int unum=u[i];
				x+=xy[snum][0]-xy[unum][0];
				y+=xy[snum][1]-xy[unum][1];
			}
			answer=Math.min(answer,(x*x)+(y*y));
			return ;
		}
		for(int i=start;i<N;i++){
			select[i]=true;
			combi(cnt+1,i+1);
			select[i]=false;
		}
	}
}//end of class 

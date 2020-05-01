import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_15686_치킨배달 {
	static int N,M,answer;
	static int map[][];
	static List<int[]> chicken;
	static int [][][] dist;
	static List<int []> home;
	static int select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		answer=Integer.MAX_VALUE;
		map=new int [N+1][N+1];
		chicken=new LinkedList<int[]>();
		home=new LinkedList<int []>();
		select=new int [M];
		for(int i=1;i<=N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2){
					chicken.add(new int [] {i,j});
				}else if(map[i][j]==1)
					home.add(new int []{i,j});
			}
		}
		int hcnt=home.size();
		int ccnt=chicken.size();
		dist=new int [N+1][N+1][ccnt];
		for(int i=0;i<hcnt;i++){
			int hx=home.get(i)[0];
			int hy=home.get(i)[1];
			for(int j=0;j<ccnt;j++){
				int cx=chicken.get(j)[0];
				int cy=chicken.get(j)[1];
				dist[hx][hy][j]=Math.abs(hx-cx)+Math.abs(hy-cy);
			}
		}
		combi(0,0,ccnt);
		System.out.println(answer);
	}//end of main
	private static void combi(int start, int cnt,int ccnt) {
		if(cnt==M){
			int sum=0;
			for(int i=0;i<home.size();i++){
				int min=Integer.MAX_VALUE;
				int hx=home.get(i)[0];
				int hy=home.get(i)[1];
				for(int j=0;j<M;j++){
					int c=select[j];
					min=Math.min(min, dist[hx][hy][c]);
				}
				sum+=min;
			}
			answer=Math.min(answer, sum);
			return ;
		}
		for(int i=start;i<ccnt;i++){
			select[cnt]=i;
			combi(i+1,cnt+1,ccnt);
		}
	}
}//end of class 

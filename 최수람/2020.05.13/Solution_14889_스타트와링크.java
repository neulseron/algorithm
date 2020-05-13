
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14889_스타트와링크 {
	static int N;
	static int power[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		power=new int [N][N];
		answer=Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				power[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int select[]=new int [N];
		select[0]=1;
		combi(0,1,select);
		System.out.println(answer);
	}//end of main
	private static void combi(int cnt, int start,int[] select) {
		if(cnt==N/2-1){
			//능력치 계산
			int team1[]=new int [N/2];
			int team2[]=new int [N/2];
			int index1=0,index2=0;
			int power1=0,power2=0;
			for(int i=0;i<N;i++){
				if(select[i]==1){
					team1[index1++]=i;
				}else{
					team2[index2++]=i;
				}
			}
			for(int i=0;i<N/2;i++){
				for(int j=i+1;j<N/2;j++){
					power1+=power[team1[i]][team1[j]];
					power1+=power[team1[j]][team1[i]];
					power2+=power[team2[i]][team2[j]];
					power2+=power[team2[j]][team2[i]];
				}
			}
			//최솟값 갱신 
			answer=Math.min(answer,Math.abs(power1-power2));
			return;
		}
		for(int i=start;i<N;i++){
			select[i]=1;
			combi(cnt+1,i+1,select);
			select[i]=0;
		}
	}
}//end of class 

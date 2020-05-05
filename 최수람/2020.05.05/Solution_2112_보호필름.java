

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//접근한 방법 : 시뮬레이션: 처음 성능검사 진행 -> 성능 검사 통과 못한 열을 중심으로 약품 투입할 막 선택 (이미 성능 검사 통과한 열에 영향을 덜 끼치는 걸로)
//너무 복잡함
//풀이 참고 : 조합 + 백트래킹 
public class Solution_2112_보호필름 {
	static int D,W,K;
	static int map[][];
	static int answer;
	static boolean selected[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("2112_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			D=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new int [D][W];
			selected=new boolean [D];
			answer=Integer.MAX_VALUE;
			for(int i=0;i<D;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<W;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,0);
			System.out.println("#"+tc+" "+answer);
		}
	}//end of main
	private static void dfs(int start,int cnt) {
		if(cnt>=answer){
			return ;
		}else if(cnt>K){
			return ;
		}
		if(check()){
			answer=Math.min(answer, cnt);
			return;
		}
		for(int i=start;i<D;i++){
			if(selected[i]) continue;
			selected[i]=true;
			int copy[]=Arrays.copyOf(map[i],map[i].length);
			for(int j=0;j<2;j++){
				Arrays.fill(map[i],j);
				dfs(i,cnt+1);
				map[i]=Arrays.copyOf(copy,map[i].length);
			}
			selected[i]=false;
		}
	}
	private static boolean check(){
		for(int i=0;i<W;i++){
			int A_cnt=0;
			int B_cnt=0;
			boolean flag=false;
			for(int j=0;j<D;j++){
				if(map[j][i]==0){
					B_cnt++;
					A_cnt=0;
				}else{
					A_cnt++;
					B_cnt=0;
				}
				if(A_cnt==K || B_cnt==K){
					flag=true;
				}
			}
			if(!flag)
				return false;
		}
		return true;
	}
}//end of class 

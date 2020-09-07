package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	static int D,W,K;
	static int answer;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			D=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			answer=K;
			map=new int [D][W];
			for(int i=0;i<D;i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			if(check()) {
				answer=0;
			}else {
				for(int i=0;i<D;i++) {
					for(int k=0;k<2;k++) {
						int tmp[]=new int [W];
						tmp=Arrays.copyOf(map[i], W);
						Arrays.fill(map[i],k);
						dfs(i,1);
						map[i]=Arrays.copyOf(tmp, W);
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	private static void dfs(int idx,int cnt) {
		if(answer<cnt){
        	return;
        }
		if(cnt>K) {
            return;
		}
		//성능검사
		if(check()) {
			answer=Math.min(answer,cnt);
			return;
		}
		for(int i=idx+1;i<D;i++) {
			for(int k=0;k<2;k++) {
				int tmp[]=new int [W];
				tmp=Arrays.copyOf(map[i], W);
				Arrays.fill(map[i],k);
				dfs(i,cnt+1);
				map[i]=Arrays.copyOf(tmp, W);
			}
		}
	}
	private static boolean check() {
		for(int i=0;i<W;i++) {
			int k=1;
			boolean pos=false;
			int type=map[0][i];
			for(int j=1;j<D;j++) {
				if(type==map[j][i]) {
					k++;
				}else{
					type=map[j][i];
					k=1;
				}
				if(k>=K) {
					pos=true;
					break;
				}
			}
			if(!pos)
				return false;
		}
		return true;
	}
}//end of class 

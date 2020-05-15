import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14890_경사로 {
	static int N,L;
	static int map[][];
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		map=new int [N][N];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//행 검사 
		for(int i=0;i<N;i++){
			boolean same=true;
			int num=map[i][0];
			int cnt=1;
			boolean pos=true;
			boolean need=false;
			for(int j=1;j<N;j++){
				if(num!=map[i][j]){
					same=false;
					if(Math.abs(num-map[i][j])>1){
						pos=false;
						break;
					}
					if(num<map[i][j]){
						//경사로가 필요한 시점
						if(need){ // 앞에서 사용해야 할 경사로라면 
							if(cnt<2*L){
								pos=false;
								break;
							}else{
								need=false;
							}
						}
						if(cnt<L){
							pos=false;
							break;
						}
					}else{
						//앞으로 경사로 필요
						if(need){
							if(cnt<L){
								pos=false;
								break;
							}
						}
						need=true;
					}
					num=map[i][j];
					cnt=1;
				}else{
					cnt++;
				}
			}
			if(need){
				if(cnt<L){
					pos=false;
				}
			}
			if(pos || same){
				answer++;
			}
		}
		//열 검사 
		for(int i=0;i<N;i++){
			boolean same=true;
			int num=map[0][i];
			int cnt=1;
			boolean pos=true;
			boolean need=false;
			for(int j=1;j<N;j++){
				if(num!=map[j][i]){
					same=false;
					if(Math.abs(num-map[j][i])>1){
						pos=false;
						break;
					}
					if(num<map[j][i]){
						//경사로가 필요한 시점
						if(need){ // 앞에서 사용해야 할 경사로라면 
							if(cnt<2*L){
								pos=false;
								break;
							}else{
								need=false;
							}
						}
						if(cnt<L){
							pos=false;
							break;
						}
					}else{
						//앞으로 경사로 필요
						if(need){
							if(cnt<L){
								pos=false;
								break;
							}
						}
						need=true;
					}
					num=map[j][i];
					cnt=1;
				}else{
					cnt++;
				}
			}
			if(need){
				if(cnt<L){
					pos=false;
				}
			}
			if(pos || same){
				answer++;
			}
		}
		System.out.println(answer);
	}//end of main
}//end of class 

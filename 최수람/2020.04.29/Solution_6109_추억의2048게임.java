import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임 {
	static int answer[][];
	static int map[][];
	static int dir,N;
	static boolean check[][];
	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("6109_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine().trim()," ");
			N=Integer.parseInt(st.nextToken());
			String d=st.nextToken();
			answer=new int [N][N];
			map=new int [N][N];
			check=new boolean[N][N];
			if("up".equals(d)){
				dir=0;
			}else if("down".equals(d)){
				dir=1;
			}else if("left".equals(d)){
				dir=2;	
			}else if("right".equals(d)){
				dir=3;
			}
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			switch(dir){
			case 0:
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(map[i][j]!=0){
							move(i,j);
						}
					}
				}
				break;
			case 1:
				for(int i=N-1;i>=0;i--){
					for(int j=0;j<N;j++){
						if(map[i][j]!=0){
							move(i,j);
						}
					}
				}
				break;
			case 2:
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(map[i][j]!=0){
							move(i,j);
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<N;i++){
					for(int j=N-1;j>=0;j--){
						if(map[i][j]!=0){
							move(i,j);
						}
					}
				}
				break;
			}

			System.out.println("#"+t);
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(answer[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	static int dij[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static void move(int i, int j) {
		int num=map[i][j];
		while(true){
			int ni=i+dij[dir][0];
			int nj=j+dij[dir][1];
			if(ni<0||ni>=N||nj<0||nj>=N){
				ni-=dij[dir][0];
				nj-=dij[dir][1];
				answer[ni][nj]=num;
				break;
			}else if(answer[ni][nj]==0){
				i=ni;
				j=nj;
				continue;
			}else if(answer[ni][nj]==num){
				if(!check[ni][nj]){
					answer[ni][nj]=answer[ni][nj]+num;
					check[ni][nj]=true;					
				}else{
					ni-=dij[dir][0];
					nj-=dij[dir][1];
					answer[ni][nj]=num;
				}	
				break;
			}else if(answer[ni][nj]!=num){
				ni-=dij[dir][0];
				nj-=dij[dir][1];
				answer[ni][nj]=num;
				break;
			}	
		}
	}

}

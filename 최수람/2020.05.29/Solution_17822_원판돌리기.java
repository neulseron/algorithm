import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_17822_원판돌리기 {
	static int N,M,T;
	static int circle[][];
	static List<int []> erase;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		circle=new int [N][M];
		erase=new LinkedList<>();
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				circle[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int turn=1;turn<=T;turn++){
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			//원판 회전 
			rotate(x,d,k);
//			for (int[] arr : circle) {
//				System.out.println(Arrays.toString(arr));
//			}
			//원판 숫자 바꾸기 
			change();
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				answer+=circle[i][j];
			}
		}
//		for (int[] arr : circle) {
//			System.out.println(Arrays.toString(arr));
//		}
		System.out.println(answer);
	}//end of main
	private static void change() {
		//지워야하는 좌표 리스트 
		erase.clear();
		//이미 erase에 들어간 좌표인지
		boolean check[][]=new boolean[N][M];
		int sum=0;
		int numcnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				int num=circle[i][j];
				if(num==0) continue;
				sum+=num;
				numcnt++;
				check[i][j]=true;
				int cnt=0; // 같은 숫자가 있는지
				//원판번호로 인접한 곳 검사
				if(i==0){
					if(num==circle[i+1][j]){
						cnt++;
						if(!check[i+1][j]){
							erase.add(new int []{i+1,j});
							check[i+1][j]=true;							
						}
					}
				}else if(1<=i&&i<N-1){
					if(num==circle[i-1][j]){
						cnt++;
						if(!check[i-1][j]){
							erase.add(new int []{i-1,j});
							check[i-1][j]=true;		
						}
					}
					if(num==circle[i+1][j]){
						cnt++;
						if(!check[i+1][j]){
							erase.add(new int []{i+1,j});
							check[i+1][j]=true;							
						}
					}
				}else if(i==N-1){
					if(num==circle[i-1][j]){
						cnt++;
						if(!check[i-1][j]){
							erase.add(new int []{i-1,j});
							check[i-1][j]=true;		
						}
					}
				}
				//인덱스로 인접한 곳 검사 
				if(j==0){
					if(num==circle[i][j+1]){
						cnt++;
						if(!check[i][j+1]){
							check[i][j+1]=true;
							erase.add(new int []{i,j+1});							
						}
					}
					if(num==circle[i][M-1]){
						cnt++;
						if(!check[i][M-1]){
							check[i][M-1]=true;
							erase.add(new int []{i,M-1});							
						}
					}
				}else if(1<=j&&j<M-1){
					if(num==circle[i][j+1]){
						cnt++;
						if(!check[i][j+1]){
							check[i][j+1]=true;
							erase.add(new int []{i,j+1});							
						}
					}
					if(num==circle[i][j-1]){
						cnt++;
						if(!check[i][j-1]){
							check[i][j-1]=true;
							erase.add(new int []{i,j-1});							
						}
					}
				}else if(j==M-1){
					if(num==circle[i][0]){
						cnt++;
						if(!check[i][0]){
							check[i][0]=true;
							erase.add(new int []{i,0});							
						}
					}
					if(num==circle[i][j-1]){
						cnt++;
						if(!check[i][j-1]){
							check[i][j-1]=true;
							erase.add(new int []{i,j-1});							
						}
					}
				}
				if(cnt>0){
					erase.add(new int []{i,j});
				}
			}
		}
		//인접한 숫자들이 다 다른 경우 
		if(erase.size()==0){
			double avg=(double) sum/numcnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(circle[i][j]==0) continue;
					if(avg>circle[i][j]){
						circle[i][j]+=1;
					}else if(avg<circle[i][j]){
						circle[i][j]-=1;
					}
				}
			}
		}else{
			for (int[] xy : erase) {
				circle[xy[0]][xy[1]]=0;
			}
		}
		
	}
	private static void rotate(int x, int d, int k) {
		// x 배수 번호 원판 d 방향으로 k 만큼 돌리기 
		for(int idx=0;idx<N;idx++){
			if((idx+1)%x==0){
				int tmp[]=Arrays.copyOf(circle[idx],M);
				//시계방향 
				if(d==0){
					for(int j=0;j<M;j++){
						circle[idx][(j+k)%M]=tmp[j];
					}
				}
				//반시계방향 
				else if(d==1){
					for(int j=0;j<M;j++){
						circle[idx][j]=tmp[(j+k)%M];
					}
				}
			}
		}
	}
}//end of class 

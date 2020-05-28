import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//상어를 한칸씩 옮기면 시간초과가 날 거라는건 예상하고 있었는데 어떤 규칙을 가지고 움직이는지 감을 잡지 못했다.
public class Solution_17143_낚시왕 {
	static int R,C,M;
	static class Shark{
		int s;
		int d;
		int z;
		public Shark(int s,int d,int z){
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}
	static Shark map[][];
	static Shark newmap[][];
	static int answer=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new Shark[R][C];
		newmap=new Shark[R][C];
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			map[x-1][y-1]=new Shark(s,d-1,z);
		}
		solution();
		System.out.println(answer);
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
	private static void solution() {
		for(int i=0;i<C;i++){
			//1. 낚시왕이 가장 위에 있는 상어 낚아감
			for(int j=0;j<R;j++){			
				if(map[j][i]!=null){
					answer+=map[j][i].z;
					map[j][i]=null;
					break;
				}
			}
			//2. 상어 이동 
			for(int r=0;r<R;r++){
				for(int c=0;c<C;c++){
					if(map[r][c]!=null){
						//이동 
						int nr=r;
						int nc=c;
						int s=map[r][c].s;
						int d=map[r][c].d;
						int z=map[r][c].z;
						int move=s;
						if(d==0 || d==1){
							move%=(R*2-2);
							while(move>0){
								if(nr==0){
									d=1;
								}
								if(nr==R-1){
									d=0;
								}
								nr+=dir[d][0];
								move--;
							}
						}else if(d==2 || d==3){
							move%=(C*2-2);
							while(move>0){
								if(nc==0){
									d=2;
								}
								if(nc==C-1){
									d=3;
								}
								nc+=dir[d][1];
								move--;
							}
						}
						//현재 자리에 상어가 존재하는지 ? 
						if(newmap[nr][nc]!=null){
							if(newmap[nr][nc].z<z){
								newmap[nr][nc]=new Shark(s,d,z);
							}
						}else{
							newmap[nr][nc]=new Shark(s,d,z);
						}
						map[r][c]=null;
					}
				}
			}
			//map->newmap으로 복사
			//newmap 초기화 
			for(int r=0;r<R;r++){
				map[r]=Arrays.copyOf(newmap[r],C);
			}
			for(int r=0;r<R;r++){
				Arrays.fill(newmap[r], null);
			}
		}
		
	}
}//end of class 

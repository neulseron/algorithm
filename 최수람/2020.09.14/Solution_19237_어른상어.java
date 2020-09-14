package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_19237_어른상어 {
	static int N,M,K;
	static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int num;
		boolean dead;
		public Shark(int x,int y,int num) {
			this.x=x;
			this.y=y;
			this.num=num;
			this.dead=false;
		}
		@Override
		public int compareTo(Shark o) {
			return Integer.compare(this.num, o.num);
		}
	}
	static class Map{
		int smell;
		int time;
		int startT;
		List<Shark> shark;
		public Map(int smell,int time,int startT) {
			this.smell=smell;
			this.time=time;
			this.startT=startT;
			shark=new LinkedList<>();
		}
	}
	static int dir[][][];
	static List<Shark> sharks;
	static int curD[];
	static Map map[][];
	static List<Shark> dead;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new Map[N][N];
		curD=new int [M+1];
		dir=new int [M+1][5][4];
		dead=new LinkedList<>();
		sharks=new LinkedList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				int n=Integer.parseInt(st.nextToken());
				if(n==0) {
					map[i][j]=new Map(0,0,0);
				}else {
					Shark s=new Shark(i,j,n);
					sharks.add(s);
					map[i][j]=new Map(n,K,0);
					map[i][j].shark.add(s);
				}
			}
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=M;i++) {
			curD[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M*4;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int k=0;k<4;k++) {
				dir[(i/4)+1][(i%4)+1][k]=Integer.parseInt(st.nextToken());
			}
		}
		boolean res=move();
		if(res) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}//end of main
	static int movedir[][]= {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean move() {
		int second=1;
		int res=M;
		while(second<=1000) {
			
			//상어이동 
			for(int i=0;i<sharks.size();i++) {
				Shark s=sharks.get(i);
				if(s.dead) continue;
				//현재 방향에 맞게 우선순위 돌기 
				int cd=curD[s.num];
				boolean con=false;
				map[s.x][s.y].shark.clear();
				//아무 냄새없는 인접한 곳 찾기 
				for(int di=0;di<4;di++) {
//					System.out.println(s.num+" "+cd+" "+di);
					int d=dir[s.num][cd][di];
					int nx=s.x+movedir[d][0];
					int ny=s.y+movedir[d][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(map[nx][ny].smell==0) {
						map[nx][ny].shark.add(s);
						curD[s.num]=d;
						con=true;
						break;
					}
				}
				//아무 냄새없는 인접한 곳이 존재하지 않을때 - 내냄새로 찾기 
				if(!con) {
					for(int di=0;di<4;di++) {
						int d=dir[s.num][cd][di];
						int nx=s.x+movedir[d][0];
						int ny=s.y+movedir[d][1];
						if(nx<0||nx>=N||ny<0||ny>=N) continue;
						if(map[nx][ny].smell==s.num) {
							map[nx][ny].shark.add(s);
							curD[s.num]=d;
							break;
						}
					}
				}
			}
			//한 칸에 여러마리 있는 상어 처리  && map - time 줄이기 (startT != second)
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {	
					if(map[i][j].shark.size()>1) {
						Collections.sort(map[i][j].shark);
						Shark s=map[i][j].shark.get(0);
						map[i][j].smell=s.num;
						map[i][j].time=K;
						map[i][j].startT=second;
						s.x=i;
						s.y=j;
						for(int k=1;k<map[i][j].shark.size();k++) {
							Shark sh=map[i][j].shark.get(k);
							sh.dead=true;
							res--;
						}
						map[i][j].shark.clear();
						map[i][j].shark.add(s);
					}else if(map[i][j].shark.size()==1) {
						Shark s=map[i][j].shark.get(0);
						map[i][j].smell=s.num;
						map[i][j].time=K;
						map[i][j].startT=second;
						s.x=i;
						s.y=j;
					}
					if(map[i][j].smell!=0 && map[i][j].startT<second) {
						map[i][j].time--;
						if(map[i][j].time==0) {
							map[i][j]=new Map(0,0,0);
						}
					}
				}
			}
			//shark.size 체크 
			if(res<=1) {
				answer=second;
				return true;
			}
//			for (Shark s : sharks) {
//				System.out.println(s.num+" "+s.x+" "+s.y+" "+curD[s.num]);
//			}
//			System.out.println(second+"-------------------------------");
			second++;
		}
		return false;
	}
}//end of class 

package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static int N,M,K;
	static int [][] check;
	static int map[][];
	static Queue<int []> cells;
	static int answer;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("5653_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new int [500][500];
			check=new int [500][500];
			for(int i=0;i<500;i++){
				Arrays.fill(check[i], -1);
			}
			cells=new LinkedList<int[]> ();
			answer=0;
			K=Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<M;j++){
					int num=Integer.parseInt(st.nextToken());
					if(num!=0){
						map[i+150][j+150]=num;
						check[i+150][j+150]=0;
						cells.add(new int [] {i+150,j+150,num,0,0,0}); // x,y,생명력,활성화여부,활성화된 시간,생성시간 
					}
				}
			}
			solution();
			for (int [] cell : cells) {
				int x=cell[0];
				int y=cell[1];
				if(map[x][y]==cell[2])
					answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	static int dir[][]={{0,1},{0,-1},{-1,0},{1,0}};
	private static void solution() {
		for(int k=1;k<=K;k++){
			int qsize=cells.size();
			for(int i=0;i<qsize;i++){
				int cur[]=cells.poll();
				int x=cur[0];
				int y=cur[1];
				if(map[x][y]!=cur[2]) continue;
				boolean change=false;
				if(cur[3]==0 && cur[5]+cur[2]==k){ //비활성화 -> 활성화 
					cells.add(new int [] {x,y,cur[2],1,k,cur[5]});
					change=true;
				}
				if(cur[3]==1 && cur[4]+1==k){ // 번식 	
					for(int d=0;d<4;d++){
						int nx=x+dir[d][0];
						int ny=y+dir[d][1];
						if(check[nx][ny]!=-1 && check[nx][ny]<k) continue; 
						if(check[nx][ny]==-1 || check[nx][ny]==k){
							if(map[nx][ny]<map[x][y]){
								cells.add(new int [] {nx,ny,map[x][y],0,0,k});
								map[nx][ny]=map[x][y];
								check[nx][ny]=k;
							}
						}
							
					}
				}
				if(cur[3]==1 && cur[4]+cur[2]==k){
					change=true;
				}
				if(!change){
					cells.add(new int [] {x,y,cur[2],cur[3],cur[4],cur[5]});
				}
			}
		}
	}
}//end of class

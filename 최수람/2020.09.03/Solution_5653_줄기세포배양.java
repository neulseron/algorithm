package swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static int N,M,K;
	static class Cell{
		int x;
		int y;
		int power;
		int active_time;
		int born_time;
		boolean active;
		boolean dead;
		public Cell(int x,int y,int power,int active_time,int born_time) {
			this.x=x;
			this.y=y;
			this.power=power;
			this.active_time=active_time;
			this.born_time=born_time;
			this.active=false;
			this.dead=false;
		}
	}
	static List<Cell> map[][];
	static List<Cell> cells;
	static int [][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("5653_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new List[500][500];
			cells=new LinkedList<>();
			for(int i=0;i<500;i++) {
				for(int j=0;j<500;j++) {
					map[i][j]=new LinkedList<>();
				}
			}
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int num=Integer.parseInt(st.nextToken());
					if(num!=0) {
						map[i+150][j+150].add(new Cell(i+150,j+150,num,-1,0));
					}
				}
			}
			for(int k=1;k<=K;k++) {
				addList();
				for(int idx=0;idx<cells.size();idx++) {
					Cell cell=cells.get(idx);
					//비활성 -> 활성 
					if(!cell.active&&cell.born_time+cell.power==k) {
						cell.active_time=k;
						cell.active=true;
					}

					//번식 
					if(cell.active&&!cell.dead&&cell.active_time+1==k) {
						for(int d=0;d<4;d++) {
							int nx=cell.x+dir[d][0];
							int ny=cell.y+dir[d][1];
							//번식할 자리에 세포가 존재?
							if(map[nx][ny].size()>0) {
								//전에 태어난 세포가 있으면 번식 불가능 
								//지금 태어난 세포 라면 ? 생명력 비교하기 
								if(map[nx][ny].get(0).born_time==k) {
									if(map[nx][ny].get(0).power<cell.power) {
										map[nx][ny].clear();
										map[nx][ny].add(new Cell(nx,ny,cell.power,-1,k));
									}
								}
							}else {
								map[nx][ny].add(new Cell(nx,ny,cell.power,-1,k));
							}
						}
					}
					//활성 -> 죽이기 
					if(cell.active&&!cell.dead&&cell.active_time+cell.power==k) {
						cell.dead=true;
					}
				}
				addMap();
				cells.clear();
			}
			int count=0;
			for(int i=0;i<500;i++) {
				for(int j=0;j<500;j++) {
					if(map[i][j].size()>0) {
						if(!map[i][j].get(0).dead) {
							count++;
						}
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}//end of main
	private static void addMap() {
		for(int i=0;i<cells.size();i++) {
			Cell cell=cells.get(i);
			map[cell.x][cell.y].add(cell);
		}
	}
	private static void addList() {
		for(int i=0;i<500;i++) {
			for(int j=0;j<500;j++) {
				if(map[i][j].size()!=0&&!map[i][j].get(0).dead) {
					cells.add(map[i][j].get(0));
				}
			}
		}
	}
}//end of class 



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
	static int N,answer;
	static int map[][];
	static List<int []>[] hall;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("5650_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine().trim());
			map=new int [N][N];
			answer=0;
			hall=new LinkedList[5];
			for(int i=0;i<5;i++){
				hall[i]=new LinkedList<int[]>();
			}
			StringTokenizer st=null;
			for(int i=0;i<N;i++){
				st=new StringTokenizer(br.readLine().trim()," ");
				for(int j=0;j<N;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
					if(6<=map[i][j]&&map[i][j]<=10){
						int num=map[i][j];
						hall[num-6].add(new int []{i,j});
					}
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j]==0){
						for(int d=0;d<4;d++){
							int score=start(i,j,d);
							answer=Math.max(answer, score);
						}
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static int start(int sx, int sy, int d) {
		int score=0;
		boolean con=true;
		int cx=sx;
		int cy=sy;
		int nx=0,ny=0;
		while(con){ // 게임 진행
			while(true){ // move
				nx=cx+dir[d][0];
				ny=cy+dir[d][1];
			//	System.out.println(nx+" "+ny);
				if(nx==sx&&ny==sy){
					con=false;
					break;
				}
				if(nx<0||nx>=N||ny<0||ny>=N){ //벽에 부딫혔을때 
					cx=nx;
					cy=ny;
					score++;
					switch(d){
					case 0: d=1;
							break;
					case 1: d=0;
							break;
					case 2: d=3;
							break;
					case 3: d=2;
							break;
					}
				}
				else if(map[nx][ny]==-1){
					con=false;
					break;
				}
				else if(map[nx][ny]==0){
					cx=nx;
					cy=ny;
				}
				else if(1<=map[nx][ny]&&map[nx][ny]<=5){ // 블록에 부딪혔을때
					cx=nx;
					cy=ny;
					score++;
					switch(map[nx][ny]){
					case 1: 
						if(d==0){
							d=1;
						}else if(d==1){
							d=3;
						}else if(d==2){
							d=0;
						}else if(d==3){
							d=2;
						}
						break;
					case 2: 
						if(d==0){
							d=3;
						}else if(d==1){
							d=0;
						}else if(d==2){
							d=1;
						}else if(d==3){
							d=2;
						}
						break;
					case 3: 
						if(d==0){
							d=2;
						}else if(d==1){
							d=0;
						}else if(d==2){
							d=3;
						}else if(d==3){
							d=1;
						}
						break;
					case 4: 
						if(d==0){
							d=1;
						}else if(d==1){
							d=2;
						}else if(d==2){
							d=3;
						}else if(d==3){
							d=0;
						}
						break;
					case 5: 
						if(d==0){
							d=1;
						}else if(d==1){
							d=0;
						}else if(d==2){
							d=3;
						}else if(d==3){
							d=2;
						}
						break;
					}		
				}
				else if(6<=map[nx][ny]&&map[nx][ny]<=10)
				{ // 웜홀에 부딪혔을떄
					int num=map[nx][ny]-6;
					int h1[]=hall[num].get(0);
					int h2[]=hall[num].get(1);
					if(h1[0]==nx && h1[1]==ny){
						cx=h2[0];
						cy=h2[1];
					}else if(h2[0]==nx && h2[1]==ny){
						cx=h1[0];
						cy=h1[1];
					}
				}
			}
		}
		return score;
	}
}//end of class 

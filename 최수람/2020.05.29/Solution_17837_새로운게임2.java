

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
// 너무 복잡하게 생각하지 말기 
// 처음에 말 정보 따로, map 정보 따로 , map에 존재하는 말 정보를 따로 담았는데, 방향이나 위치가 바뀔때, 동기화가 잘 안되서 
// 테케부터 틀렸음. 범위가 작기 때문에 map 정보 따로, map에 존재하는 말 정보까지 담아도 괜찮음.
public class Solution_17837_새로운게임2 {
	static int N,K;
	static int map[][];
	static class Horse{
		int idx;
		int d;
		public Horse(int idx,int d){
			this.idx=idx;
			this.d=d;
		}
	}
	static List<Horse> board[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int [N][N];
		board=new LinkedList [N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[i][j]=new LinkedList<>();
			}
		}
		
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++){
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			board[x][y].add(new Horse(i,d));
		}
		int answer=solution();
//		int sum=0;
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				sum+=board[i][j].size();
//				System.out.println(i+" "+j+" "+board[i][j].size());
//			}
//		}
		System.out.println(answer);
	}//end of main
	static int dir[][]={{0,1},{0,-1},{-1,0},{1,0}};
	private static int solution() {
		for(int turn=1;turn<=1000;turn++){
			//0번부터 k-1번 말까지 이동 
			for(int idx=0;idx<K;idx++){
				if(findHorse(idx))
					return turn;
			}
		}
		return -1;
	}
	
	private static boolean findHorse(int idx){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				for(int k=0;k<board[i][j].size();k++){
					if(idx==board[i][j].get(k).idx){
						return move(i,j,board[i][j].get(k).d,idx,k);
					}
				}
			}
		}
		return false;
	}
	private static boolean blue(int x,int y,int d,int idx,int index){
		int nx=x+dir[d][0];
		int ny=y+dir[d][1];
		if(nx<0||nx>=N||ny<0||ny>=N){
			return false; 
		}else if(map[nx][ny]==0){
			white(x,y,d,idx,index);
		}else if(map[nx][ny]==1){
			red(x,y,d,idx,index);
		}else if(map[nx][ny]==2){
			return false;
		}
		if(0<=nx&&nx<N&&0<=ny&&ny<N){
			if(board[nx][ny].size()>=4){
				return true;
			}
		}
		return false;
	}
	private static void red(int x,int y,int d,int idx,int index){
		int nx=x+dir[d][0];
		int ny=y+dir[d][1];
		for(int i=board[x][y].size()-1;i>=index;i--){
			board[nx][ny].add(board[x][y].get(i));
		}
		board[x][y]=new LinkedList<>(board[x][y].subList(0, index));
	}
	private static void white(int x,int y,int d,int idx,int index){
		int nx=x+dir[d][0];
		int ny=y+dir[d][1];
		for(int i=index;i<board[x][y].size();i++){
			board[nx][ny].add(board[x][y].get(i));
		}
			board[x][y]=new LinkedList<>(board[x][y].subList(0, index));
	}
	private static boolean move(int x,int y,int d,int idx,int index){
		int nx=x+dir[d][0];
		int ny=y+dir[d][1];
		if(nx<0||nx>=N||ny<0||ny>=N){
			if(d==0){
				d=1;
			}else if(d==1){
				d=0;
			}else if(d==2){
				d=3;
			}else if(d==3){
				d=2;
			}
			board[x][y].get(index).d=d;
			return blue(x, y, d,idx,index);
		}else if(map[nx][ny]==0){
			white(x, y, d, idx,index);
		}else if(map[nx][ny]==1){
			red(x,y,d,idx,index);
		}else if(map[nx][ny]==2){
			if(d==0){
				d=1;
			}else if(d==1){
				d=0;
			}else if(d==2){
				d=3;
			}else if(d==3){
				d=2;
			}
			board[x][y].get(index).d=d;
			return blue(x,y,d,idx,index);
		}
		if(0<=nx&&nx<N&&0<=ny&&ny<N){
			if(board[nx][ny].size()>=4){
				return true;
			}
		}
		return false;
	}

}//end of class 

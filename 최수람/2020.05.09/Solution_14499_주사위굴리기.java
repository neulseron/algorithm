
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14499_주사위굴리기 {
	//주사위 위치를 관리할 좌표 
	static class Dice{
		int back;
		int up;
		int front;
		int bottom;
		int left;
		int right;
		public Dice(int back, int up, int front, int bottom, int left, int right) {
			super();
			this.back = back;
			this.up = up;
			this.front = front;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
		}
	}
	static int N,M,x,y,K;
	static int map[][];
	static int order[];

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int [N][M];
		order=new int [K];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<K;i++){
			order[i]=Integer.parseInt(st.nextToken());
		}
		move();
	}//end of main
	static int dir[][]={{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	private static void move() {
		int dice_num[]=new int [7];// 주사위의 숫자를 저장할 배열
		Dice dice=new Dice(2,1,5,6,4,3);
		for(int i=0;i<K;i++){
			int tmp=0;
			int d=order[i];
			int nx=x+dir[d][0];
			int ny=y+dir[d][1];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			switch(d){
			//동쪽(오른쪽)
			case 1:
				tmp=dice.right;
				dice.right=dice.bottom;
				dice.bottom=dice.left;
				dice.left=dice.up;
				dice.up=tmp;
				break;
			//서쪽(왼쪽)
			case 2:
				tmp=dice.left;
				dice.left=dice.bottom;
				dice.bottom=dice.right;
				dice.right=dice.up;
				dice.up=tmp;
				break;
			//북쪽(윗쪽)
			case 3:
				tmp=dice.front;
				dice.front=dice.bottom;
				dice.bottom=dice.back;
				dice.back=dice.up;
				dice.up=tmp;
				break;
			//남쪽(아랫쪽)
			case 4:
				tmp=dice.bottom;
				dice.bottom=dice.front;
				dice.front=dice.up;
				dice.up=dice.back;
				dice.back=tmp;
				break;
			}
			if(map[nx][ny]==0){
				map[nx][ny]=dice_num[dice.bottom];
			}else if(map[nx][ny]!=0){
				dice_num[dice.bottom]=map[nx][ny];
				map[nx][ny]=0;
			}
			x=nx;
			y=ny;
			System.out.println(dice_num[dice.up]);
		}
	}
}//end of class 

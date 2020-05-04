

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3190_뱀 {
	static int N;
	static int map[][];
	static int change[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		map=new int [N][N];
		int cnt=Integer.parseInt(br.readLine().trim());
		StringTokenizer st=null;
		for(int i=0;i<cnt;i++){
			st=new StringTokenizer(br.readLine()," ");
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			//사과가 있는 칸 2로 표시 
			map[r][c]=2;
		}
		cnt=Integer.parseInt(br.readLine().trim());
		change=new int [10000];
		for(int i=0;i<cnt;i++){
			st=new StringTokenizer(br.readLine()," ");
			int sc=Integer.parseInt(st.nextToken());
			int d=0;
			String s=st.nextToken();
			//왼쪽으로 90도 꺾어야하는 경우 -1
			if(s.equals("L")){
				d=-1;
			}else if(s.equals("D")){ // 오른쪽으로 90도 꺾어야하는 경우 1
				d=1;
			}
			change[sc]=d;
		}
		
		int answer=solution();
		System.out.println(answer);
	}//end of main
	static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
	private static int solution() {
		//뱀이 있는 곳 1로 표시 
		Queue<int[]> snake=new LinkedList<>();
		map[0][0]=1;
		int r=0;
		int c=0;
		int answer=0;
		snake.add(new int []{0,0});
		//초기 방향은 오른쪽 
		int d=3;
		while(true){
			answer++;
			int nr=r+dir[d][0];
			int nc=c+dir[d][1];
			if(nr<0||nr>=N||nc<0||nc>=N){
				return answer;
			}else if(map[nr][nc]==1){
				return answer;
			}else if(map[nr][nc]==2){
				map[nr][nc]=1;
				snake.add(new int []{nr,nc});
			}else if(map[nr][nc]!=2){
				map[nr][nc]=1;
				int tail[]=snake.poll();
				snake.add(new int []{nr,nc});
				map[tail[0]][tail[1]]=0;
			}
			r=nr;
			c=nc;
//			System.out.println(answer);
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			if(change[answer]!=0){
				int ch=change[answer];
				switch(d){
				case 0:
					d=ch==-1? 2:3;
					break;
				case 1:
					d=ch==-1? 3:2;
					break;
				case 2:
					d=ch==-1? 1:0;
					break;
				case 3:
					d=ch==-1? 0:1;
					break;
				}
			}
		}
	}
}//end of class 

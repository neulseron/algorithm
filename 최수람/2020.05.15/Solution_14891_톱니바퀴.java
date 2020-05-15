

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_14891_톱니바퀴 {
	static int gear[][];
	static int K;
	static boolean check[];
	static List<int []> turn;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		gear=new int [4][8];
		for(int i=0;i<4;i++){
			String str=br.readLine();
			for(int j=0;j<8;j++){
				gear[i][j]=str.charAt(j)-'0';
			}
		}
		K=Integer.parseInt(br.readLine().trim());
		turn=new LinkedList<>();
		StringTokenizer st=null;
		for(int i=0;i<K;i++){
			st=new StringTokenizer(br.readLine()," ");
			int idx=Integer.parseInt(st.nextToken())-1;
			int dir=Integer.parseInt(st.nextToken());
			check=new boolean[4];
			check[idx]=true;
			turn.clear();
			turn.add(new int [] { idx,dir});
			solve(idx,dir);
			for(int j=0;j<turn.size();j++){
//				System.out.println(Arrays.toString(turn.get(i)));
				rotate(turn.get(j)[0],turn.get(j)[1]);
			}
		}
//			for (int [] arr : gear) {
//				System.out.println(Arrays.toString(arr));
//			}
//			System.out.println("----------------------------");
		int score=0;
		if(gear[0][0]==1) score+=1;
		if(gear[1][0]==1) score+=2;
		if(gear[2][0]==1) score+=4;
		if(gear[3][0]==1) score+=8;
		System.out.println(score);
	}//end of main
	private static void solve(int idx, int dir) {
		if(idx==0){
			if(gear[idx][2]!=gear[idx+1][6]){
				if(!check[idx+1]){
					check[idx+1]=true;
					turn.add(new int []{idx+1,(-1)*dir});
					solve(idx+1,(-1)*dir);					
				}
			}
		}else if(1<=idx&&idx<=2){
			if(gear[idx][2]!=gear[idx+1][6]){
				if(!check[idx+1]){
					check[idx+1]=true;
					turn.add(new int []{idx+1,(-1)*dir});
					solve(idx+1,(-1)*dir);					
				}
			}
			if(gear[idx][6]!=gear[idx-1][2]){
				if(!check[idx-1]){
					check[idx-1]=true;
					turn.add(new int []{idx-1,(-1)*dir});
					solve(idx-1,(-1)*dir);					
				}
			}
		}else if(idx==3){
			if(gear[idx][6]!=gear[idx-1][2]){
				if(!check[idx-1]){
					check[idx-1]=true;
					turn.add(new int []{idx-1,(-1)*dir});
					solve(idx-1,(-1)*dir);					
				}
			}
		}
	}
	private static void rotate(int idx, int dir) {
		//회전 
		int newgear[]=new int [8];
		if(dir==1){ //시계방향 
			int tmp=gear[idx][7];
			for(int i=0;i<7;i++){
				newgear[i+1]=gear[idx][i];
			}
			newgear[0]=tmp;
		}else if(dir==-1){
			int tmp=gear[idx][0];
			for(int i=7;i>=1;i--){
				newgear[i-1]=gear[idx][i];
			}
			newgear[7]=tmp;
		}
		gear[idx]=Arrays.copyOf(newgear,8);
	}
}//end of class 

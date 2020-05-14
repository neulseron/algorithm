
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_14888_연산자끼워넣기 {
	static int N;
	static int nums[];
	static int op[];
	static int min,max;
	static int select[];
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine().trim());
		nums=new int [N];
		op=new int[N-1];
		select=new int [N-1];
		check=new boolean [N-1];
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			nums[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		int index=0;
		for(int i=0;i<4;i++){
			int cnt=Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++){
				op[index]=i;
				index++;
			}
		}
		dfs(0,select);
		System.out.println(max);
		System.out.println(min);
	}//end of main
	private static void dfs(int idx,int select[]) {
		if(idx==N-1){
			int res=cal(select);
			min=Math.min(min, res);
			max=Math.max(max,res);
			return ;
		}
		for(int i=0;i<N-1;i++){
			if(!check[i]){
				check[i]=true;
				int newselect[]=Arrays.copyOf(select, select.length);
				newselect[idx]=op[i];
				dfs(idx+1,newselect);
				check[i]=false;
			}
		}
	}
	private static int cal(int[] select) {
		int res=nums[0];
		for(int i=0;i<N-1;i++){
			if(select[i]==0){//+
				res+=nums[i+1];
			}else if(select[i]==1){//-
				res-=nums[i+1];
			}else if(select[i]==2){//*
				res*=nums[i+1];
			}else if(select[i]==3){// /
				//음수 체크 
				if((res>0&&nums[i+1]>0)||(res<0&&nums[i+1]<0)){
					res/=nums[i+1];
				}else{
					int tmp=Math.abs(res)/Math.abs(nums[i+1]);
					res=(-1)*tmp;
				}
			}
		}
		return res;
	}
}//end of class 

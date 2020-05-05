

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13458_시험감독 {

	public static void main(String[] args) throws Exception{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int N=Integer.parseInt(br.readLine().trim());
			long nums[]=new long [N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				nums[i]=Integer.parseInt(st.nextToken());
			}
			long sv[]=new long [2];
			st=new StringTokenizer(br.readLine()," ");
			sv[0]=Integer.parseInt(st.nextToken()); //총감독관
			sv[1]=Integer.parseInt(st.nextToken()); //부감독관
			long answer=N;//시험장마다 총감독관이 한명씩 있어야 하므로 
			long num=0;
			for(int i=0;i<N;i++){
				num=nums[i];
				num-=sv[0];
				if(num<=0) continue;
				if(num%sv[1]==0){
					answer+=(long)(num/sv[1]);
				}else{
					answer+=(long)(num/sv[1])+1;
				}
			}
			System.out.println(answer);
	}//end of main
}//end of class 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			long answer=0;
			long sum=0;
			long discount=0;
			int N=Integer.parseInt(br.readLine());
			int price[]=new int [N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				price[i]=Integer.parseInt(st.nextToken());
				sum+=price[i];
			}
			Arrays.sort(price);
			int mod=N%3;
			if(mod==0){
				int res=N;
				for(int i=0;i<N;i++){
					if(i%3==0){
						if(res>=3){
							discount+=price[i];
							res-=3;
						}
					}
				}
			}else if(mod ==1){
				int res=N-1;
				for(int i=1;i<N;i++){
					if(i%3==1){
						if(res>=3){
							discount+=price[i];
							res-=3;
						}
					}
				}
				
			}else{
				int res=N-2;
				for(int i=2;i<N;i++){
					if(i%3==2){
						if(res>=3){
							discount+=price[i];
							res-=3;
						}
					}
				}
			}
			answer=sum-discount;
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
}//end of class 

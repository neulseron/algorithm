import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++){
			long answer=0;
			String b=br.readLine();
			String t=br.readLine();
			int blength=b.length();
			int tlength=t.length();
			// 0 -> 1  / 1 -> 0
			for(int i=0;i<blength;i++){
				boolean con=true;
				char[]tmp=b.toCharArray();
				if(b.charAt(i)=='1'){
					tmp[i]='0';
				}else if(b.charAt(i)=='0'){
					tmp[i]='1';
				}
				String btmp=String.valueOf(tmp);
				for(int j=0;j<tlength;j++){
					char[]tmp2=t.toCharArray();
					long num=cal(btmp,2);
					//System.out.println(num);
					if(t.charAt(j)=='1'){
						tmp2[j]='0';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
						tmp2[j]='2';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
					}else if(t.charAt(j)=='2'){
						tmp2[j]='1';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
						tmp2[j]='0';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
					}else if(t.charAt(j)=='0'){
						tmp2[j]='1';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
						tmp2[j]='2';
						if(num==cal(String.valueOf(tmp2),3)){
							answer=num;
							con=false;
							break;
						}
					}
				}
				if(!con)
					break;
			}
			System.out.println("#"+tc+" "+answer);
			
		}
	}//end of main

	private static long cal(String nums, int num) {
		long sum=0;
		int length=nums.length();
		for(int i=0;i<length;i++){
			sum+=(nums.charAt(i)-'0')*Math.pow(num,(length-1)-i);
		}
		return sum;
	}
}//end of class 

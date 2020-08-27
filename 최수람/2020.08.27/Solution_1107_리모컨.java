package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1107_리모컨 {
	static boolean disable[];
	static int pos[];
	static int answer=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		disable=new boolean[10];
		int M=Integer.parseInt(br.readLine());
		if(M!=0) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");			
			for(int i=0;i<M;i++) {
				int index=Integer.parseInt(st.nextToken());
				disable[index]=true;
			}
		}
		answer=Math.abs(N-100);
		for(int n=0;n<=888888;n++) {
			boolean pos=true;
			if(Math.abs(n-N)+(n+"").length()<answer) {
				String str=n+"";
				for(int i=0;i<str.length();i++) {
					int idx=str.charAt(i)-'0';
					if(disable[idx]) {
						pos=false;
						break;
					}
				}
				if(pos) {
					answer=Math.abs(n-N)+str.length();
				}
			}
	 }
	 System.out.println(answer);
	}//end of main
}//end of class 

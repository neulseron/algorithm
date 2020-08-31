package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기 {
	static int p,q;
	static String master[];
	static String my[];
	static int res[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			master=new String [p];
			my=new String [q];
			res=new int [q];
			Arrays.fill(res, -2);
			res[0]=0;
			for(int i=0;i<p;i++) {
				master[i]= br.readLine();
			}
			for(int i=0;i<q;i++) {
				my[i]=br.readLine();
			}
			for(int r=1;r<=20;r++) {
				for(int c=1;c<=20;c++) {
					for(int s=1;s<=20;s++) {
						if(possible(r,c,s)) {
							//System.out.println(r+" "+c+" "+s);
							doIndent(r,c,s);
						}
					}
				}
			}
			System.out.print("#"+t+" ");
			for (int i : res) {
				System.out.print(i+" ");
			}
			System.out.println();
	   }
	}//end of main
	private static void doIndent(int r, int c, int s) {
		int a=0,b=0,cc=0,d=0,e=0,f=0;
	
		for(int i=1;i<q;i++) {
			for(int j=0;j<my[i-1].length();j++) {
				if(my[i-1].charAt(j)=='(') a++;
				if(my[i-1].charAt(j)==')') b++;
				if(my[i-1].charAt(j)=='{') cc++;
				if(my[i-1].charAt(j)=='}') d++;
				if(my[i-1].charAt(j)=='[') e++;
				if(my[i-1].charAt(j)==']') f++;
			}
			int result=r*(a-b)+c*(cc-d)+s*(e-f);
			if(res[i]!=-2&&res[i]!=result) {
				res[i]=-1;
			}else {
				res[i]=result;
			}
		}
	}
	private static boolean possible(int r, int c, int s) {
		int a=0,b=0,cc=0,d=0,e=0,f=0;
		for(int i=1;i<p;i++) {
			int dot=0;
			for(int j=0;j<master[i].length();j++) {
				if(master[i].charAt(j)=='.') {
					dot++;
				}else {
					break;
				}
			}
			for(int j=0;j<master[i-1].length();j++) {
				if(master[i-1].charAt(j)=='(') a++;
				if(master[i-1].charAt(j)==')') b++;
				if(master[i-1].charAt(j)=='{') cc++;
				if(master[i-1].charAt(j)=='}') d++;
				if(master[i-1].charAt(j)=='[') e++;
				if(master[i-1].charAt(j)==']') f++;
			}
			if(r*Math.abs(a-b)+c*Math.abs(cc-d)+s*Math.abs(e-f)!=dot)
				return false;
		}
		return true;
	}
}//end of class 

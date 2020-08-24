package swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_ÇÜ¹ö°Å´ÙÀÌ¾îÆ® {
	static int N,L;
	static int ing[][]; // 0 : ¸À      1:Ä®·Î¸®
	static int max[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			ing=new int [N+1][2];
			max=new int [N+1][L+1];
			for(int i=1;i<=N;i++) {
				st=new StringTokenizer(br.readLine()," ");
				ing[i][0]=Integer.parseInt(st.nextToken());
				ing[i][1]=Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				for(int j=0;j<ing[i][1];j++) {
					max[i][j]=max[i-1][j];
				}
				for(int j=ing[i][1];j<=L;j++) {
					max[i][j]=Math.max(max[i-1][j], max[i-1][j-ing[i][1]]+ing[i][0]);
				}
			}
			
			System.out.println("#"+t+" "+max[N][L]);
		}
	}//end of main

}//end of class 

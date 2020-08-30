package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1717_집합의표현 {
	static int N,M;
	static int parent[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int [N+1];
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int type=Integer.parseInt(st.nextToken());
			int set1=Integer.parseInt(st.nextToken());
			int set2=Integer.parseInt(st.nextToken());
			if(type==0) {
				union(set1,set2);
			}else if(type==1) {
				int p1=find(set1);
				int p2=find(set2);
				System.out.println(p1==p2? "YES":"NO");
			}
		}
	}//end of main
	static int find(int idx) {
		if(parent[idx]==idx)
			return idx;
		return parent[idx]=find(parent[idx]);
	}
	static void union(int set1,int set2) {
		int p1=find(set1);
		int p2=find(set2);
		if(p1!=p2) {
			parent[p1]=p2;
		}
	}
}//end of class 

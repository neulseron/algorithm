package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4386_별자리만들기 {
	static int N;
	static double stars[][];
	//간적크간만프
	//간선 N*(N-3)/2 
	//크루스칼 알고리즘
	static class Edge implements Comparable<Edge>{
		int s1;
		int s2;
		double dist;
		public Edge(int s1,int s2, double dist) {
			this.s1=s1;
			this.s2=s2;
			this.dist=dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	static int parent[];
	static List<Edge> edges;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		stars=new double[N+1][2];
		parent=new int [N+1];
		edges=new LinkedList<>();
		StringTokenizer st=null;
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			stars[i][0]=Double.parseDouble(st.nextToken());
			stars[i][1]=Double.parseDouble(st.nextToken());
			parent[i]=i;
		}
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				double dx=Math.pow((stars[i][0]-stars[j][0]),2);
				double dy=Math.pow((stars[i][1]-stars[j][1]),2);				
				edges.add(new Edge(i,j,Math.sqrt(dx+dy)));
			}
		}
		Collections.sort(edges);
		double answer=0.0;
		int cnt=0;
		int idx=0;
		while(cnt<N-1) {
			int s1=edges.get(idx).s1;
			int s2=edges.get(idx).s2;
			int p1=find(s1);
			int p2=find(s2);
			if(p1==p2) {
				idx++;
				continue;
			}else {
				union(p1,p2);
				answer+=edges.get(idx).dist;
				idx++;
				cnt++;
			}
		}
		System.out.println(answer);
	}//end of main
	private static void union(int p1, int p2) {
		if(p1==p2) return ;
		parent[p1]=p2;
	}
	private static int find(int i) {
		if(parent[i]==i) return i;
		return parent[i]=find(parent[i]);
	}
}//end of class 

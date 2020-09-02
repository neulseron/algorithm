package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1647_도시분할계획_kruskal {
	//MST 생성한 다음 가장 유지비가 비싼 길 끊기 
	//kruskal 알고리즘 적용
	static int N,M;
	static class Vertex implements Comparable<Vertex>{
		int c1;
		int c2;
		int cost;
		public Vertex(int c1,int c2,int cost) {
			this.c1=c1;
			this.c2=c2;
			this.cost=cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static PriorityQueue<Vertex> pq;
	static int parent[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int [N+1];
		pq=new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int c1=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			pq.add(new Vertex(c1,c2,cost));
		}
		int sum=0;
		int max=0;
		int con=0;
		while(!pq.isEmpty()) {
			Vertex cur=pq.poll();
			int p1=find(cur.c1);
			int p2=find(cur.c2);
			if(p1!=p2) {
				union(p1,p2);
				sum+=cur.cost;
				con++;
				max=Math.max(max, cur.cost);
			}
			if(con==N-1)
				break;
		}
		System.out.println(sum-max);
	}//end of main
	private static void union(int p1, int p2) {
		parent[p1]=p2;
		
	}
	private static int find(int idx) {
		if(parent[idx]==idx)
			return idx;
		return parent[idx]=find(parent[idx]);
	}
}//end of class 

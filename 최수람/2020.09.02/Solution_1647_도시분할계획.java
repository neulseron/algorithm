package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1647_도시분할계획 {
	//MST 생성한 다음 가장 유지비가 비싼 길 끊기 
	//prim 알고리즘 적용 
	//kruskal 알고리즘을 먼저 적용했으나 시간초과 --> 정렬때문에 그런듯 
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
	static List<Vertex> adj[];
	static int sum;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		adj=new List[N+1];
		for(int i=1;i<=N;i++) {
			adj[i]=new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int c1=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			adj[c1].add(new Vertex(c1,c2,cost));
			adj[c2].add(new Vertex (c2,c1,cost));
		}
		Prim();
		System.out.println(sum-max);
	}//end of main
	private static void Prim() {
		PriorityQueue<Vertex> pq=new PriorityQueue<>();
		boolean check[]=new boolean [N+1];
		check[1]=true;
		for (Vertex v : adj[1]) {
			pq.add(v);
		}
		int con=1;
		while(!pq.isEmpty()) {
			Vertex cur=pq.poll();
			if(check[cur.c2]) continue;
			check[cur.c2]=true;
			sum+=cur.cost;
			max=Math.max(max, cur.cost);
			con++;
			if(con==N) break;
			for(Vertex v:adj[cur.c2]) {
					pq.add(v);
			}
		}
	}
}//end of class 

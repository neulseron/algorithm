package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1916_최소비용구하기 {
	static int N,M;
	static int dist[];
	static List<int[]> adj[];
	static int S,D;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		dist=new int [N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		adj=new List[M];
		for(int i=0;i<M;i++) {
			adj[i]=new LinkedList<>();
		}
		StringTokenizer st=null;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int cost=Integer.parseInt(st.nextToken());
			adj[s].add(new int [] {d,cost});
		}
		st=new StringTokenizer(br.readLine()," ");
		S=Integer.parseInt(st.nextToken())-1;
		D=Integer.parseInt(st.nextToken())-1;
		bfs();
		System.out.println(dist[D]);
	}//end of main
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx,int cost) {
			this.idx=idx;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost,o.cost);
		}
	}
	private static void bfs() {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(S,0));
		dist[S]=0;
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			if(cur.cost>dist[cur.idx]) {
				continue;
			}
			if(cur.idx==D) {
				return;
			}
			for (int[] line : adj[cur.idx]) {
				if(line[1]+dist[cur.idx]<dist[line[0]]) {
					dist[line[0]]=line[1]+dist[cur.idx];
					pq.add(new Node(line[0],dist[line[0]]));
				}
			}
		}
	}
}//end of class 

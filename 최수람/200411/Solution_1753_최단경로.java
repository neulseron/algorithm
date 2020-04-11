
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1753_최단경로 {
	static int V,E,S;
	static class Edge implements Comparable<Edge>{
		int dest;
		int weight;
		public Edge(int d,int w){
			this.dest=d;
			this.weight=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight,o.weight);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(br.readLine().trim())-1;
		List<Edge>[] adj=new ArrayList[V];
		for(int i=0;i<V;i++){
			adj[i]=new ArrayList<>();
		}
		int s,w,d;
		for(int i=0;i<E;i++){
			st=new StringTokenizer(br.readLine()," ");
			s=Integer.parseInt(st.nextToken())-1;
			d=Integer.parseInt(st.nextToken())-1;
			w=Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(d, w));
		}
		Edge dist[]=new Edge[V];
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		boolean check[]=new boolean[V];
		for(int i=0;i<V;i++){			
			dist[i]=new Edge(i, Integer.MAX_VALUE);			
			pq.add(dist[i]);
		}
		pq.remove(dist[S]);
		dist[S]=new Edge(S,0);
		pq.add(dist[S]);
		while(!pq.isEmpty()){
			Edge edge=pq.poll();
			if(edge.weight==Integer.MAX_VALUE)
				break;
			for (Edge next : adj[edge.dest]) {
				if(!check[next.dest]&&dist[next.dest].weight>dist[edge.dest].weight+next.weight){
					dist[next.dest].weight=dist[edge.dest].weight+next.weight;
					pq.remove(dist[next.dest]);
					pq.add(dist[next.dest]);
				}
			}
			check[edge.dest]=true;
		}
		for (int i = 0; i < V; i++) {
			System.out.println(dist[i].weight==Integer.MAX_VALUE? "INF":dist[i].weight);
		}
	}// end of main
}// end of class 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
	static int N,M;
	static class Edge implements Comparable<Edge>{
		int idx;
		int cost;
		public Edge(int idx,int cost){
			this.idx=idx;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int dist[];
	static List<Edge> adj[];
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(br.readLine())-1;
		adj=new LinkedList[N];
		dist=new int [N];
		check=new boolean[N];
		for(int i=0;i<N;i++){
			adj[i]=new LinkedList<>();
			dist[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(d,c));
		}
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		dist[start]=0;
		check[start]=true;
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()){
			Edge cur=pq.poll();
			check[cur.idx]=true;
			for (Edge edge : adj[cur.idx]) {
				if(!check[edge.idx]&&dist[edge.idx]>dist[cur.idx]+edge.cost){
					dist[edge.idx]=dist[cur.idx]+edge.cost;
					pq.add(new Edge(edge.idx,dist[edge.idx]));
				}
			}
		}
		for(int i=0;i<N;i++){
			if(i==start){
				System.out.println(0);
			}else{
				System.out.println(dist[i]==Integer.MAX_VALUE? "INF":dist[i]);
			}
		}
	}//end of main
}//end of class 

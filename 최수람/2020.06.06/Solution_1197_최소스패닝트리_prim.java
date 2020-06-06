import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {
	static int N,M;
	static class Vertex implements Comparable<Vertex>{
		int start;
		int dest;
		int weight;
		public Vertex(int start,int dest,int weight){
			this.start=start;
			this.dest=dest;
			this.weight=weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static List<Vertex> adj[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int answer=0;
		adj=new LinkedList[N];
		boolean check[]=new boolean[N];
		for(int i=0;i<N;i++){
			adj[i]=new LinkedList<>();
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			adj[s].add(new Vertex(s,d,weight));
			adj[d].add(new Vertex(d,s,weight));
		}
		Vertex[] v=new Vertex[N];
		for(int i=0;i<N;i++){
			v[i]=new Vertex(i,-1,Integer.MAX_VALUE);
		}
		v[0].weight=0;
		v[0].dest=0;
		check[0]=true;
		PriorityQueue<Vertex> pq=new PriorityQueue<>();
		for(int i=0;i<N;i++){
			pq.add(v[i]);
		}
		while(!pq.isEmpty()){
			Vertex cur=pq.poll();
			answer+=cur.weight;
			int s=cur.start;
			check[s]=true;
			for(int i=0;i<adj[s].size();i++){
				int next=adj[s].get(i).dest;
				if(v[next].weight>adj[s].get(i).weight){
					if(check[next]) continue;
					v[next].weight=adj[s].get(i).weight;
					pq.remove(v[next]);
					pq.add(v[next]);
				}
			}
		}
		System.out.println(answer);
	}//end of main
}//end of class 

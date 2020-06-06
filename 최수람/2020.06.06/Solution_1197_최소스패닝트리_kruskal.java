import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal {
	static int N,M;
	static int parent[];
	static class Vertex implements Comparable<Vertex>{
		int s;
		int d;
		int weight;
		public Vertex(int s,int d,int weight){
			this.s=s;
			this.d=d;
			this.weight=weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static PriorityQueue<Vertex> vertexes;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int [N];
		vertexes=new PriorityQueue<>();
		for(int i=0;i<N;i++){
			parent[i]=i;
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int weight=Integer.parseInt(st.nextToken());
			vertexes.add(new Vertex(s,d,weight));
		}
		int choose=0;
		int answer=0;
		while(!vertexes.isEmpty()){
			if(choose==N-1){
				break;
			}
			Vertex cur=vertexes.poll();
			int p1=find(cur.s);
			int p2=find(cur.d);
			if(p1!=p2){
				union(cur.s,cur.d);
				choose++;
				answer+=cur.weight;
			}
		}
		System.out.println(answer);
	}//end of main
	private static void union(int s, int d) {
		int p1=find(s);
		int p2=find(d);
		if(p1!=p2){
			parent[p1]=p2;
		}
	}
	private static int find(int idx) {
		if(parent[idx]==idx)
			return idx;
		return parent[idx]=find(parent[idx]);
	}
}//end of class 

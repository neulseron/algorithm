

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로_prim{
	static int N;
	static int x[];
	static int y[];
	static int p[];
	static double E;
	static double answer;
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		long cost;
		public Edge(int v1,int v2,long cost){
			this.v1=v1;
			this.v2=v2;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("1251_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine());
			x=new int [N];
			y=new int [N];
			p=new int [N];
			answer=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				x[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				y[i]=Integer.parseInt(st.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			solution();
			answer=Math.round(answer*E);
			System.out.print("#"+t+" ");
			System.out.printf("%.0f\n",answer);

		}
		
	}//end of main
	private static void solution() {
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		boolean check[]=new boolean[N];
		ArrayList<Edge> edges[]=new ArrayList[N];
		for(int i=0;i<N;i++)
			edges[i]=new ArrayList<>();
		// 간선 생성하기 
		for(int i=0;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				long dist=(long) (Math.pow((x[i]-x[j]), 2)+Math.pow((y[i]-y[j]), 2));
				edges[i].add(new Edge(i,j,dist));
				edges[j].add(new Edge(j,i,dist));
			}
		}
		// 정점 선택 
		check[0]=true;
		int cnt=1;
		queue.addAll(edges[0]);
		while(cnt!=N){
			Edge cur=queue.poll();
			if(check[cur.v2])
				continue;
			check[cur.v2]=true;
			answer+=cur.cost;
			queue.addAll(edges[cur.v2]);
			cnt++;
		}
	}
}//end of class 

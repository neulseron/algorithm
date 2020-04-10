

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class EEdge{
	public int v1;
	public int v2;
	public long L;
	public EEdge(){}
}
public class Solution_1251_하나로_kruskal {
	static int N;
	static int x[];
	static int y[];
	static double E;
	static double answer;
	static int parents[];

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1251_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N=Integer.parseInt(br.readLine());
			x=new int [N];
			y=new int [N];
			answer=0;
			parents=new int [N];
			for(int i=0;i<N;i++){
				parents[i]=i;
			}
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
		//1. 간선 만들기 
		ArrayList<EEdge> edges=new ArrayList<>();
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				EEdge e=new EEdge();
				e.v1=i;
				e.v2=j;
				e.L=(long) (Math.pow((x[i]-x[j]), 2)+Math.pow((y[i]-y[j]), 2));
				edges.add(e);
			}
		}
		//2. 간선 정렬하기 
		Collections.sort(edges,new Comparator<EEdge>() {

			@Override
			public int compare(EEdge o1, EEdge o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1.L, o2.L);
			}
		});
		//3. kruskal 알고리즘 적용 
		int cnt=0;
		for(int i=0;i<edges.size();i++){
			int a=findSet(edges.get(i).v1);
			int b=findSet(edges.get(i).v2);
			if(a==b)
				continue;
			union(a,b);
			answer+=edges.get(i).L;
			cnt++;
			if(cnt==N-1){
				break;
			}
		}
	}
	private static void union(int a, int b) {
		int p1=findSet(a);
		int p2=findSet(b);
		parents[p1]=p2;
	}
	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x])
			return x;
		else {
			parents[x]=findSet(parents[x]);
			return parents[x];
		}
	}
}// end of class 

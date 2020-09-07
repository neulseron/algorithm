package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2252_줄세우기 {
	static int N,M; 
	static int front[];
	static int answer[];
	static boolean check[];
	static List<Integer> adj[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		front=new int [N+1];
		answer=new int [N+1];
		check=new boolean [N+1];
		adj=new List[N+1];
		int idx=0;
		for(int i=1;i<=N;i++) {
			adj[i]=new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int f=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			adj[f].add(b);
			front[b]++;
		}
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(front[i]==0) {
				q.add(i);
			}
		}
		for(int i=1;i<=N;i++) {
			int cur=q.poll();
			if(check[cur]) continue;
			check[cur]=true;
			answer[i]=cur;
			for(int j:adj[cur]) {
				front[j]--;
				if(front[j]==0 && !check[j]) {
					q.add(j);
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.print(answer[i]+" ");
		}
	}//end of main
}//end of class 

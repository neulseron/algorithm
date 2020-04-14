

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int start;
	static List<Integer> adj[];
	static int answer;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("1238_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			adj=new LinkedList[101];
			for(int i=0;i<=100;i++){
				adj[i]=new LinkedList<>();
			}
			st=new StringTokenizer(br.readLine()," ");
			answer=0;
			for(int i=0;i<N/2;i++){
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				adj[from].add(to);
			}
			bfs();
			System.out.println("#"+t+" "+answer);
		}
	}//end of main
	private static void bfs() {
		boolean check[]=new boolean[101];
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		check[start]=true;
		int depth=1;
		int maxDepth=0;
		while(!q.isEmpty()){
			int qsize=q.size();
			for(int ql=0;ql<qsize;ql++){
				int cur=q.poll();
				int size=adj[cur].size();
				boolean end=true;
				for(int i=0;i<size;i++){
					int to=adj[cur].get(i);
					if(!check[to]){
						end=false;
						q.add(to);
						check[to]=true;
					}
				}
				if(size==0 || end){
					if(maxDepth==depth){
						answer=Math.max(answer, cur);
					}
					else if(maxDepth<depth){
						answer=cur;
						maxDepth=depth;
					}
				}
			}
			depth++;
		}
	}
				
}//end of class 

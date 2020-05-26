
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//구현이 어려운건 아닌데 시간초과때메 힘들었음 ㅠ 
//list에서 add연산이 시간을 많이 잡아먹는다는 것을 깨달았음..
//tree class선언이랑, sort를 매번해서 시간이 다른사람보다 더 오래걸리는 듯
public class Solution_16253_나무재테크_pq {
	static int N,M,K;
	static int A[][];
	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;
		public Tree(int x,int y,int age){
			this.x=x;
			this.y=y;
			this.age=age;
		}
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	static List<Tree> trees,newtree;
	static int plus[][];
	static PriorityQueue<Tree> pq;
	static List<Tree> death;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		A=new int [N][N];
		trees=new LinkedList<>();
		newtree=new LinkedList<>();
		death=new LinkedList<>();
		plus=new int [N][N];
		pq=new PriorityQueue<>();
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				plus[i][j]=5;
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int age=Integer.parseInt(st.nextToken());
			pq.add(new Tree(x,y,age));
		}
		solution();
		System.out.println(pq.size());
	}//end of main
	static int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	private static void solution() {
		for(int year=0;year<K;year++){
			//봄 
			trees.clear();
			death.clear();
			while(!pq.isEmpty()){
				Tree tree=pq.poll();
				int x=tree.x;
				int y=tree.y;
				if(tree.age>plus[x][y]){
					death.add(tree);
				}else{
					plus[x][y]-=tree.age;
					tree.age+=1;
					trees.add(tree);
				}
			}
			pq.addAll(trees);
			//여름
			for(Iterator<Tree> it=death.iterator();it.hasNext();){
				Tree tree=it.next();
				plus[tree.x][tree.y]+=tree.age/2;
			}
			//가을 
			for(Iterator<Tree> it=trees.iterator();it.hasNext();){
				Tree tree=it.next();
				if(tree.age%5==0){
					int x=tree.x;
					int y=tree.y;
					for(int d=0;d<8;d++){
						int nx=x+dir[d][0];
						int ny=y+dir[d][1];
						if(0<=nx&&nx<N&&0<=ny&&ny<N){
							pq.add(new Tree(nx,ny,1));
						}
					}
				}
			}
			//겨울
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					plus[i][j]+=A[i][j];
				}
			}
			if(pq.isEmpty()){
				return;
			}
		}
	}
}//end of class 

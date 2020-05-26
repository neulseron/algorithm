
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
//구현이 어려운건 아닌데 시간초과때메 힘들었음 ㅠ 
//list에서 add연산이 시간을 많이 잡아먹는다는 것을 깨달았음..
//tree class선언이랑, sort를 매번해서 시간이 다른사람보다 더 오래걸리는 듯
//성능 개선 --> list 정렬하는것이 아니고 deque처럼 추가,삭제 방향을 다르게 해야함 ! 
public class Solution_16253_나무재테크 {
	static int N,M,K;
	static int A[][];
	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;
		boolean alive;
		public Tree(int x,int y,int age){
			this.x=x;
			this.y=y;
			this.age=age;
			this.alive=true;
		}
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	static List<Tree> trees;
	static List<Tree> ground[][];
	static int plus[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		A=new int [N][N];
		ground=new LinkedList[N][N];
		trees=new LinkedList<>();
		plus=new int [N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(plus[i], 5);
		}
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++){
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				ground[i][j]= new LinkedList<>();
			}
		}
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int age=Integer.parseInt(st.nextToken());
			Tree tree=new Tree(x,y,age);
			ground[x][y].add(tree);
		}
		solution();
		System.out.println(trees.size());
	}//end of main
	static int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	private static void solution() {
		for(int year=0;year<K;year++){
			//봄 & 여름
			trees.clear();
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!ground[i][j].isEmpty()){
						Collections.sort(ground[i][j]);
						int newplus=0;
						for(Iterator<Tree> it=ground[i][j].iterator(); it.hasNext();){
							Tree tree=it.next();
							if(tree.age>plus[i][j]){
								newplus+=tree.age/2;
								it.remove();
							}else{
								plus[i][j]-=tree.age;
								tree.age+=1;
								trees.add(tree);
							}
					    }
						plus[i][j]+=newplus;
					}
				}
			}
			//여름
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					if(!ground[i][j].isEmpty()){
//						for(Iterator<Tree> it=ground[i][j].iterator(); it.hasNext();){
//							Tree tree=it.next();
//							if(!tree.alive){
//								plus[i][j]+=tree.age/2;
//								it.remove();
//							}
//						}
//					}
//				}
//			}
			//가을
			List<Tree> newTree=new LinkedList<>();
			for (Tree tree : trees) {
				if(tree.age%5==0){
					int x=tree.x;
					int y=tree.y;
					for(int d=0;d<8;d++){
						int nx=x+dir[d][0];
						int ny=y+dir[d][1];
						if(nx<0||nx>=N||ny<0||ny>=N) continue;
						Tree t=new Tree(nx,ny,1);
						ground[nx][ny].add(t);
						newTree.add(t);
					}
				}
			}
			trees.addAll(newTree);
			//겨울
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					plus[i][j]+=A[i][j];
				}
			}
			if(trees.size()==0){
				return ;
			}
		}
	}
}//end of class 

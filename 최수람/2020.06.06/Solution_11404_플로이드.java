import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Floyd_Warshall {
	static int N,M;
	static List<Integer> map[][];
	static int dist[][];
	static final int MAX=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map=new LinkedList[N][N];
		dist=new int [N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j]=new LinkedList<>();
				dist[i][j]=MAX;
			}
		}
		StringTokenizer st=null;
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine()," ");
			int s=Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			int cost=Integer.parseInt(st.nextToken());
			map[s][d].add(cost);
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				for(int k=0;k<map[i][j].size();k++){					
					dist[i][j]=Math.min(dist[i][j], map[i][j].get(k));
				}
			}
		}
		for(int k=0;k<N;k++){ // 경유점 
			for(int i=0;i<N;i++){ // 시작점 
				if(k==i) continue;
				for(int j=0;j<N;j++){ // 도착점 
					if(i==j) continue;
					if(dist[i][k]!=MAX&&dist[k][j]!=MAX &&dist[i][j]>dist[i][k]+dist[k][j]){
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(dist[i][j]==MAX?0+" ":dist[i][j]+" ");
			}
			System.out.println();
		}
		
	}//end of main
}//end of class 

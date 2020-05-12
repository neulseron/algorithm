
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_14500_테트로미노 {
	static int N,M;
	static int map[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N+1][M+1];
		int [][][]tetromino={
			    { {0,0}, {0,1}, {1,0}, {1,1} }, // ㅁ
			    { {0,0}, {0,1}, {0,2}, {0,3} }, // ㅡ
			    { {0,0}, {1,0}, {2,0}, {3,0} },
			    { {0,0}, {0,1}, {0,2}, {1,0} }, // ㄴ
			    { {0,2}, {1,0}, {1,1}, {1,2} },
			    { {0,0}, {1,0}, {1,1}, {1,2} },
			    { {0,0}, {0,1}, {0,2}, {1,2} },
			    { {0,0}, {1,0}, {2,0}, {2,1} },
			    { {0,0}, {0,1}, {1,1}, {2,1} },
			    { {0,0}, {0,1}, {1,0}, {2,0} },
			    { {0,1}, {1,1}, {2,0}, {2,1} },
			    { {0,0}, {1,0}, {1,1}, {2,1} }, // Z
			    { {0,1}, {1,0}, {1,1}, {2,0} },
			    { {0,1}, {0,2}, {1,0}, {1,1} },
			    { {0,0}, {0,1}, {1,1}, {1,2} },
			    { {0,0}, {0,1}, {0,2}, {1,1} }, // ㅗ
			    { {0,1}, {1,0}, {1,1}, {1,2} },
			    { {0,1}, {1,0}, {1,1}, {2,1} },
			    { {0,0}, {1,0}, {1,1}, {2,0} }
		};
//		//ㅡ
//		tetromino.add(new int [][]{{0,0},{0,1},{0,2},{0,3}});
//		tetromino.add(new int [][]{{0,0},{1,0},{2,0},{3,0}});
//		//네모
//		tetromino.add(new int [][]{{0,0},{0,1},{1,0},{1,1}});
//		//ㄱ
//		tetromino.add(new int [][]{{0,0},{1,0},{2,0},{2,1}});
//		tetromino.add(new int [][]{{0,0},{0,1},{1,1},{2,1}});		
//		tetromino.add(new int [][]{{0,0},{0,1},{0,2},{-1,2}});
//		tetromino.add(new int [][]{{0,0},{1,0},{0,1},{0,2}});
//		tetromino.add(new int [][]{{0,0},{0,1},{1,0},{2,0}});
//		tetromino.add(new int [][]{{0,0},{0,1},{-1,1},{-2,1}});
//		tetromino.add(new int [][]{{0,0},{0,1},{0,2},{1,2}});
//		tetromino.add(new int [][]{{0,0},{0,1},{1,1},{1,2}});
//		//번개
//		tetromino.add(new int [][]{{0,0},{1,0},{1,1},{2,1}});
//		tetromino.add(new int [][]{{0,0},{0,1},{-1,1},{-1,2}});
//		tetromino.add(new int [][]{{0,0},{0,1},{1,1},{1,2}});
//		tetromino.add(new int [][]{{0,0},{-1,0},{-1,1},{-2,1}});
//		//ㅗ
//		tetromino.add(new int [][]{{0,0},{0,1},{0,2},{1,1}});
//		tetromino.add(new int [][]{{0,0},{1,0},{2,0},{1,-1}});
//		tetromino.add(new int [][]{{0,0},{0,1},{-1,1},{0,2}});
//		tetromino.add(new int [][]{{0,0},{1,0},{2,0},{1,1}});
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				for(int k=0;k<19;k++){
					int sum=0;
					for(int n=0;n<4;n++){
						int nx=i+tetromino[k][n][0];
						int ny=j+tetromino[k][n][1];
						if(0<=nx&&nx<N&&0<=ny&&ny<M){
							sum+=map[nx][ny];
						}
					}
					answer=Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}//end of main

}//end of class

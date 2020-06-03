

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_17135_캐슬디펜스 {
	static int N,M,D;
	static int map[][];
	static class Enemy{
		int x;
		int y;
		boolean dead;
		public Enemy(int x,int y,boolean dead){
			this.x=x;
			this.y=y;
			this.dead=dead;
		}
	}
	static int answer;
	static List<Enemy> enemy;
	static int [] attackerCol;
	static int enemyCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int [N+1][M];
		enemy=new LinkedList<>();
		attackerCol=new int [3];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1){
					enemy.add(new Enemy(i,j,false));
					enemyCnt++;
				}
			}
		}
		//궁수배치하기 
		dfs(0,0);
		System.out.println(answer);
	}//end of main
	private static void dfs(int idx, int cnt) {
		if(cnt==3){
			//게임 진행 
			game();
			return ;
		}
		for(int i=idx;i<M;i++){
			attackerCol[cnt]=i;
			dfs(i+1,cnt+1);
		}
	}
	private static void game() {
		int curCnt=enemyCnt;
		int attacked=0;
		List<Enemy> curEnemy=new LinkedList<>();
		for (Enemy e : enemy) {
			curEnemy.add(new Enemy(e.x,e.y,false));
		}
		while(curEnemy.size()>0){
			//궁수가 공격할 적 선택하기 
			for(int i=0;i<3;i++){
				int ax=N;
				int ay=attackerCol[i];
				int index=0;
				int col=0;
				int minD=Integer.MAX_VALUE;
				boolean con=false;
				for(int j=0;j<curEnemy.size();j++){
					int x=curEnemy.get(j).x;
					int y=curEnemy.get(j).y;
					int curD=Math.abs(ax-x)+Math.abs(ay-y);
					if(curD<=D){
						if(minD>curD){
							minD=curD;
							index=j;
							col=y;
						}else if(minD==curD){
							if(y<col){
								index=j;
								col=y;
							}
						}
						con=true;
					}
				}
				if(!con) continue;
				if(!curEnemy.get(index).dead){
					//curCnt--;
					attacked++;
					curEnemy.get(index).dead=true;
				}
			}
			//적 한칸씩 이동하기 
			for (Enemy e : curEnemy) {
				if(e.dead) continue;
				e.x+=1;
				if(e.x==N){
					e.dead=true;
					//curCnt--;
				}
			}
			//죽어야할 적 정리하기
			for (Iterator<Enemy> iterator = curEnemy.iterator(); iterator.hasNext();) {
				Enemy e = iterator.next();
				if(e.dead){
					iterator.remove();
				}
			}
		}
		answer=Math.max(answer, attacked);
	}
}//end of class 

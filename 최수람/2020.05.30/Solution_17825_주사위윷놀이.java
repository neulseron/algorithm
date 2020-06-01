import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
// 관건 : 윷놀이 판 방문체크를 어떻게 할 것인지 고려
// 윳놀이 경로대로 리스트를 생성했지만, 처음에 윳놀이 판 점수가 다 다른지 알고 점수로 방문체크 했지만,알고보니 겹치는 점수가 존재했음 ㅠ
// 방문체크 : 좌표 
// 경로: 최대한 겹치지 않게 생성  
//  40 이 하나 겹쳐서 방문 체크시 40이 나오는 좌표값을 함께 검사 
// 글고 처음에는 움직일 말 고르고 움직여서 turn 10 까지 갔는데 너무 복잡하다는 걸 깨달았다.
// 앞으로 조합,순열시 한번에 처리해야하는 연산이나 조건이 많으면 조합이나 순열을 다 만들고 한꺼번에 처리하는 걸로 해야겠다.
public class Solution_17825_주사위윷놀이 {
	static List<Integer> start; //0번 경로 
	static List<Integer> ten_blue; //1번 경로 
	static List<Integer> twenty_blue; //2번 경로
	static List<Integer> thirty_blue; //3번 경로 
	static List<Integer> blues; // 4번 경로 
	static int horse[][];
	static int dice[];
	static int select[];
	static int answer=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		dice=new int [10];
		select=new int [10];
		start=new LinkedList<>();
		ten_blue=new LinkedList<>();
		twenty_blue=new LinkedList<>();
		thirty_blue=new LinkedList<>();
		blues=new LinkedList<>();
		horse=new int [4][2];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<10;i++){
			dice[i]=Integer.parseInt(st.nextToken());
		}
		//윷놀이 판 만들기 
		for(int i=0;i<=40;i+=2){
			start.add(i);
		}
		for(int i=10;i<=19;i+=3){
			ten_blue.add(i);
		}
		for(int i=20;i<=24;i+=2){
			twenty_blue.add(i);
		}
		thirty_blue.add(30);
		thirty_blue.add(28);
		thirty_blue.add(27);
		thirty_blue.add(26);
		//blue route 타면 공통으로 도달하는 루트 
		for(int i=25;i<=40;i+=5){
			blues.add(i);
		}		
		dfs(0);
		System.out.println(answer);
	}//end of main
	private static void dfs(int turn) {
		if(turn==10){
			int sum=0;
			for(int i=0;i<4;i++){
				horse[i][0]=0;
				horse[i][1]=0;
			}
			for(int i=0;i<10;i++){
				int res=move(i,select[i]);
				if(res==-1) return ;
				else sum+=res;
			}
			answer=Math.max(answer, sum);
			return;
		}
		for(int idx=0;idx<4;idx++){
			select[turn]=idx;
			dfs(turn+1);
		}
	}
	private static int move(int turn, int idx) {
		int curlist=horse[idx][0];
		int curindex=horse[idx][1];
		int nextvalue=0;
		int nextlist=curlist;
		int nextindex=curindex+dice[turn];
		if(curlist == -1 && curlist==-1){
			return -1;
		}
		switch(curlist){
		case 0:
			if(nextindex>=start.size()){
				horse[idx][0]=-1;
				horse[idx][1]=-1;
				return 0;
			}
			nextvalue=start.get(nextindex);
			if(nextvalue==10){
				nextlist=1;
				nextindex=0;
			}else if(nextvalue==20){
				nextlist=2;
				nextindex=0;
			}else if(nextvalue==30){
				nextlist=3;
				nextindex=0;
			}
			if(!check(nextlist,nextindex,nextvalue)){
				return -1;
			}
			horse[idx][0]=nextlist;
			horse[idx][1]=nextindex;
			return nextvalue;
		case 1:
			if(nextindex>=ten_blue.size()){
				if(nextindex-ten_blue.size()>=blues.size()){
					horse[idx][0]=-1;
					horse[idx][1]=-1;
					return 0;	
				}
				nextlist=4;
				nextindex=nextindex-ten_blue.size();
				nextvalue=blues.get(nextindex);
			}else{
				nextvalue=ten_blue.get(nextindex);				
			}
			if(!check(nextlist,nextindex,nextvalue)){
				return -1;
			}
			horse[idx][0]=nextlist;
			horse[idx][1]=nextindex;
			return nextvalue;
		case 2:
			if(nextindex>=twenty_blue.size()){
				if(nextindex-twenty_blue.size()>=blues.size()){
					horse[idx][0]=-1;
					horse[idx][1]=-1;
					return 0;	
				}
				nextlist=4;
				nextindex=nextindex-twenty_blue.size();
				nextvalue=blues.get(nextindex);
			}else{
				nextvalue=twenty_blue.get(nextindex);
			}
			if(!check(nextlist,nextindex,nextvalue)){
				return -1;
			}
			horse[idx][0]=nextlist;
			horse[idx][1]=nextindex;
			return nextvalue;
		case 3:
			if(nextindex>=thirty_blue.size()){
				if(nextindex-thirty_blue.size()>=blues.size()){
					horse[idx][0]=-1;
					horse[idx][1]=-1;
					return 0;	
				}
				nextlist=4;
				nextindex=nextindex-thirty_blue.size();
				nextvalue=blues.get(nextindex);
			}else{
				nextvalue=thirty_blue.get(nextindex);
			}
			if(!check(nextlist,nextindex,nextvalue)){
				return -1;
			}
			horse[idx][0]=nextlist;
			horse[idx][1]=nextindex;
			return nextvalue;
		case 4:
			if(nextindex>=blues.size()){
				horse[idx][0]=-1;
				horse[idx][1]=-1;
				return 0;	
			}
			nextvalue=blues.get(nextindex);
			if(!check(nextlist,nextindex,nextvalue)){
				return -1;
			}
			horse[idx][0]=nextlist;
			horse[idx][1]=nextindex;
			return nextvalue;
		}
		return 0;
	}
	private static boolean check(int nextlist, int nextindex,int nextvalue) {
		for(int idx=0;idx<4;idx++){
			if(horse[idx][0]==nextlist&&horse[idx][1]==nextindex){
				return false;
			}
			if(nextvalue==40){
				if(horse[idx][0]==4 && horse[idx][1]==3)
					return false;
				if(horse[idx][0]==0 &&horse[idx][1]==20){
					return false;
				}
			}
		}
		return true;
	}

}//end of class 

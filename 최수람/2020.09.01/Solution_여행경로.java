package programmers;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
public class Solution_여행경로 {

	static int N;
	static boolean visit[];
	static List<String> list;
	static String route;
	class Solution {
	    public String[] solution(String[][] tickets) {
	        N=tickets.length;
	        visit=new boolean[N];
	        list=new LinkedList<>();
	        for(int i=0;i<N;i++){
	            if(tickets[i][0].equals("ICN")){
	                visit[i]=true;
	                route=tickets[i][0]+",";
	                dfs(tickets,i,1);
	                visit[i]=false;
	            }
	        }
	        Collections.sort(list);
	        String[] answer=list.get(0).split(",");
	        return answer;
	    }
	     void dfs(String[][] tickets,int idx,int cnt){
	        route+=tickets[idx][1]+",";
	        if(cnt==N){
	            list.add(route);
	            return;
	        }
	        for(int i=0;i<N;i++){
	            if(!visit[i]&&tickets[i][0].equals(tickets[idx][1])){
	                visit[i]=true;
	                //System.out.println(i);
	                dfs(tickets,i,cnt+1);
	                route=route.substring(0,route.length()-4);
	                visit[i]=false;
	            }
	        }
	    }
	}
}

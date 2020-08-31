package programmers;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_단어변환 {
	  static List<Integer> adj[];
	    static List<Integer> start;
	    static int N;
	    static int answer;
	    public int solution(String begin, String target, String[] words) {
	        answer = Integer.MAX_VALUE;
	        N=words.length;
	        adj=new List[N];
	        start=new LinkedList<>();
	        for(int i=0;i<N;i++){
	            adj[i]=new LinkedList<>();
	        }

	        for(int i=0;i<N;i++){
	            int st=0;
	            for(int k=0;k<words[i].length();k++){
	                if(words[i].charAt(k)!=begin.charAt(k)){
	                    st++;
	                }
	            }
	            if(st==1){
	                start.add(i);
	            }
	            for(int j=0;j<N;j++){
	                if(i==j) continue;
	                int diff=0;
	                for(int k=0;k<words[i].length();k++){
	                    if(words[i].charAt(k)!=words[j].charAt(k)){
	                        diff++;
	                    }
	                }
	                if(diff==1){
	                    adj[i].add(j);
	                    adj[j].add(i);
	                }
	            }
	        }
	        for(int i=0;i<start.size();i++){
	            bfs(start.get(i),words,target);
	        }
	        answer= answer==Integer.MAX_VALUE? 0 :answer;
	        return answer;
	    }
	    static void bfs(int idx,String[] words,String target){
	        Queue<int[]> q=new LinkedList<>();
	        boolean visit[]=new boolean [N];
	        q.add(new int []{idx,1});
	        visit[idx]=true;
	        while(!q.isEmpty()){
	            int []cur=q.poll();
	            int num=cur[0];
	            int cnt=cur[1];
	            if(words[num].equals(target)){
	                answer=Math.min(answer,cnt);
	                return ;
	            }

	            for(int next : adj[num]){
	                if(!visit[next]){
	                    q.add(new int []{next,cnt+1});
	                    visit[next]=true;
	                }
	            }
	        }
	    }
	
}

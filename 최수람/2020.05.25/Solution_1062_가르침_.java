import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1062_가르침_ {
	static int N,K,answer,index;
	static String wordset[];
	static char chararr[];
	static boolean visit[];
	static int charslength;
	static HashSet<Character> chars;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		wordset=new String [N];
		chars=new HashSet<>();
		int preCount=0;
		index=0;
		for(int i=0;i<N;i++){
			String str=br.readLine();
			str=str.replaceAll("a","");
			str=str.replaceAll("n","");
			str=str.replaceAll("t","");
			str=str.replaceAll("i","");
			str=str.replaceAll("c","");
			if(str.length()==0){
				preCount++;
			}else{			
				for(int j=0;j<str.length();j++){
					chars.add(str.charAt(j));
				}
				wordset[index++]=str;
			}
		}
		K-=5;
		if(K>0){
			charslength=chars.size();
			chararr=new char[charslength];
			visit=new boolean [charslength];
			if(charslength<K) K=charslength;
			int i=0;
			for (Character character : chars) {
				chararr[i++]=character;
			}
			dfs(new HashSet<Character>(),0,0);
		}else if(K<0){
			answer=0;
			preCount=0;
		}
		System.out.println(answer+preCount);
	}//end of main
	private static void dfs(HashSet<Character> select,int idx, int cnt) {
		if(cnt==K){
			//읽을 수 있는 단어 세기
			int count=0;
			for(int i=0;i<index;i++){
				boolean pos=true;
				int len=wordset[i].length();
				for(int j=0;j<len;j++){
					if(!select.contains(wordset[i].charAt(j))){
						pos=false;
						break;
					}
				}
				if(pos) count++;
			}
			answer=Math.max(answer, count);
			return ;
		}
		for(int i=idx;i<charslength;i++){
			if(!visit[i]){
				visit[i]=true;
				select.add(chararr[i]);
				dfs(select,i,cnt+1);
				select.remove(chararr[i]);
				visit[i]=false;
			}
		}
	}
}//end of class 

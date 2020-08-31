package programmers;

public class Solution_카펫 {
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int [2];
	        for(int i=3;i<=100000;i++){
	            for(int j=3;j<=100000;j++){
	                if(dfs(i,j,brown,yellow)){
	                    answer[0]=i;
	                    answer[1]=j;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	    boolean dfs(int r,int c,int brown,int yellow){
	        if(2*r+2*(c-2)==brown&&(r-2)*(c-2)==yellow){
	            return true;
	        }
	        return false;
	    }
	}
}

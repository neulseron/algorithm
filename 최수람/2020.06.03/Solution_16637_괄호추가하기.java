

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_16637_괄호추가하기 {
	static int N;
	static class Num implements Comparable<Num>{
		int index;
		long num;
		public Num(int index,long num){
			this.index=index;
			this.num=num;
		}
		@Override
		public int compareTo(Num o) {
			return this.index-o.index;
		}
	}
	static List<Num> nums;
	static List<Integer> op;
	static boolean select[];
	static long answer;
	static int opsize;
	static String line;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		line=br.readLine();
		answer=Long.MIN_VALUE;
		nums=new LinkedList();
		op=new LinkedList<Integer>();
		for(int i=0;i<N;i++){
			if('0'<=line.charAt(i)&&line.charAt(i)<='9'){
				nums.add(new Num(i,line.charAt(i)-'0'));
			}else{
				op.add(i);
			}
		}
		opsize=op.size();
		select=new boolean [opsize];
		dfs(0);
		System.out.println(answer);
	}//end of main
	private static void dfs(int idx) {
		if(idx>=opsize){
			calculate();
			return ;
		}
		select[idx]=true;
		dfs(idx+2);
		select[idx]=false;
		dfs(idx+1);
	}
	private static void calculate() {
		//괄호 부터 처리
		List<Integer> newop=new LinkedList<>();
		PriorityQueue<Num> curnums=new PriorityQueue<>();
		for (Num num : nums) {
			curnums.add(new Num(num.index,num.num));
		}
		for(int i=0;i<opsize;i++){
			if(select[i]){
				int index=op.get(i);
				long res=cal(line.charAt(index-1),line.charAt(index),line.charAt(index+1));
				for (Iterator<Num> iter = curnums.iterator(); iter.hasNext();) {
					Num n=iter.next();
					if(n.index==index-1){
						iter.remove();
					}else if(n.index==index+1){
						iter.remove();
					}
				}
				curnums.add(new Num(index-1,res));
			}else{
				newop.add(op.get(i));
			}
		}
		//나머지 수식 
		int index=0;
		while(curnums.size()>=2){
			char op=line.charAt(newop.get(index));
			Num first=curnums.poll();
			int newindex=first.index;
			long n1=first.num;
			long n2=curnums.poll().num;
			long res=0;
			if(op=='+'){
				res=n1+n2;
			}else if(op=='-'){
				res=n1-n2;
			}else if(op=='*'){
				res=n1*n2;
			}
			curnums.add(new Num(newindex,res));
			index++;
		}
		//System.out.println(curnums.poll().num);
		answer=Math.max(answer,curnums.poll().num);
	}
	private static long cal(char n1, char op, int n2) {
		long res=0;
		if(op=='+'){
			res=(n1-'0')+(n2-'0');
		}else if(op=='-'){
			res=(n1-'0')-(n2-'0');
		}else if(op=='*'){
			res=(n1-'0')*(n2-'0');
		}
		return res;
	}
}//end of class 

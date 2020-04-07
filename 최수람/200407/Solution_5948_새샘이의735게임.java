import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_5948_새샘이의735게임 {
	static int nums[];
	static TreeSet<Integer> sums;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			nums=new int [7];
			sums=new TreeSet<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			for(int i=0;i<7;i++){
				nums[i]=Integer.parseInt(st.nextToken());
			}
			combi(0,0,0);
			ArrayList<Integer> list=new ArrayList<>();
			Iterator<Integer> it= sums.iterator();
			while(it.hasNext()){
				list.add(it.next());
			}
			System.out.println("#"+t+" "+list.get(4));
		}
	}//end of main
	private static void combi(int cnt, int start,int sum) {
		if(cnt==3){
			sums.add(sum);
			return ;
		}
		for(int i=start;i<7;i++){
			sum+=nums[i];
			combi(cnt+1,i+1,sum);
			sum-=nums[i];
		}
	}
}//end of class

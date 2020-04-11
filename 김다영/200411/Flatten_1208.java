import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		
		int dump_cnt, max, max_index, min, min_index, answer = 0;
		int j = 0;
		
		for(int i = 1; i <= 10; i++)
		{
			ArrayList<Integer> height = new ArrayList<Integer>();
			dump_cnt = scan.nextInt();
			for(j = 0; j < 100; j++)
				height.add(scan.nextInt());
			for(j = 0; j < dump_cnt; j++)
			{
				max = Collections.max(height);
				min = Collections.min(height);
				if(max - min <= 1)
					break;
				max_index  = height.indexOf(max);
				height.set(max_index, max - 1);
				min_index  = height.indexOf(min);
				height.set(min_index, min + 1);
			}
			max = Collections.max(height);
			min = Collections.min(height);
			answer = max - min;
			System.out.println("#" + i + " " + answer);
		}
	}
}

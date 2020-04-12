import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class view_1206 {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_1206.txt"));
		
		Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
		int testcase_length = 0; // 한 케이스의 건물 총 수 
		int num = 0; // 각 건물의 높이
		int cnt = 0; // 몇 번째 건물인지 확인
		int max1 = 0;
		int max2 = 0;
		int answer = 0;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			testcase_length = scan.nextInt();
			answer = 0;
			for(int j = 0; j<testcase_length; j++)
			{
				int check = 0;
				num = scan.nextInt();
				queue.add(num);
				cnt++;
				if(cnt >= 5)
				{
					ArrayList queuelist = new ArrayList(queue);
					if((int)queuelist.get(2) > (int)queuelist.get(1))
					{
						if((int)queuelist.get(2) > (int)queuelist.get(0))
						{
							check = 1;
						}
					}
					if(check == 1)
					{
						if((int)queuelist.get(2) > (int)queuelist.get(3))
						{
							if((int)queuelist.get(2) > (int)queuelist.get(4))
							{
								max1 = Math.max((int)queuelist.get(3),(int)queuelist.get(4));
								max2 = Math.max((int)queuelist.get(1),(int)queuelist.get(0));
								max1 = Math.max(max1, max2);
								answer += ((int)queuelist.get(2) - max1);
							}
						}
					}
					queue.remove();
				}
		}
		System.out.println("#" + test_case + " " + answer);
		}
	}
}
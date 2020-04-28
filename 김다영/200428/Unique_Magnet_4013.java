import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
public class Unique_Magnet_4013 {
	static ArrayList<ArrayList<Integer>> NS;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_4013.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int K, index, direction, answer = 0;
		ArrayList<Integer> NS_1;
		int j, s;
		for(int i = 1; i <= T; i++)
		{
			answer = 0;
			K = scan.nextInt();
			NS = new ArrayList<ArrayList<Integer>>();
			NS_1 = new ArrayList<Integer>();
			for(j = 0; j < 4; j++)
			{
				NS_1 = new ArrayList<Integer>();
				for(s = 0; s < 8; s++)
					NS_1.add(scan.nextInt());
				NS.add(NS_1);
			}
			
			for(j = 0; j < K; j++)
			{
				index = scan.nextInt();
				direction = scan.nextInt();
				rotation(index, direction);
			}
			for(j = 0; j < 4; j++)
			{
				if(NS.get(j).get(0) == 1)
				{
					answer += Math.pow(2, j);
				}
			}
			System.out.println("#" + i + " " + answer);
		}
	}
	public static void rotation(int index, int direction)
	{
		int[] dir = new int[4];
		dir[index-1] = direction;
		int i, tmp2;
		int tmp = direction;
		for(i = 1; i < index; i++)
		{
			if(NS.get(index - i).get(6) != NS.get(index - 1 - i).get(2))
			{
				tmp *= (-1);
				dir[index - 1 - i] = tmp;
			}
			else
				break;
		}
		
		tmp = direction;
		for(i = index; i < 4; i++)
		{
			if(NS.get(i - 1).get(2) != NS.get(i).get(6))
			{
				tmp *= (-1);
				dir[i] = tmp;
			}
			else
				break;
		}
		
		for(i = 0; i < 4; i++)
		{
			if(dir[i] == 1) // 시계방향
			{
				tmp2 = NS.get(i).get(7);
				NS.get(i).remove(7);
				NS.get(i).add(0,tmp2);
			}
			else if(dir[i] == -1) // 반시계방향
			{
				tmp2 = NS.get(i).get(0);
				NS.get(i).remove(0);
				NS.get(i).add(tmp2);
			}
		}
	}
}
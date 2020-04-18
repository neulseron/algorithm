import java.io.FileInputStream;
import java.util.Scanner;

public class Finding_A_Way_1219 {
	static int[] node_1;
	static int[] node_2;
	static int result = 0;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1219.txt"));
		Scanner scan = new Scanner(System.in);
		int i,j;
		int TC, way_length, index, value;
		for(i = 1; i <= 10; i++)
		{
			TC = scan.nextInt();
			way_length = scan.nextInt();
			node_1 = new int[100];
			node_2 = new int[100];
			result = 0;
			for(j = 0; j < way_length; j++)
			{
				index = scan.nextInt();
				value = scan.nextInt();
				if(node_1[index] == 0)
					node_1[index] = value;
				else
					node_2[index] = value;
			}
			find_way(0);
			System.out.println("#" + TC + " " + result);
		}
	}
	public static void find_way(int index)
	{
		if(node_1[index] == 99 || node_2[index] == 99)
		{
			result = 1;
		}
		else
		{
			if(node_1[index] != 0)
				find_way(node_1[index]);
			if(node_2[index] != 0)
				find_way(node_2[index]);
		}
	}
}

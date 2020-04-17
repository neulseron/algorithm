import java.io.FileInputStream;
import java.util.Scanner;
public class In_Order_1231 {
	
	static int N;
	static char[] tree_nodes;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1231.txt"));
		Scanner scan = new Scanner(System.in);
		
		int i, j;
		String str;
		for(i = 1; i <= 10; i++)
		{
			N = scan.nextInt();
			tree_nodes = new char[N + 1];
			scan.nextLine();
			for(j = 1; j <= N; j++)
			{
				str = scan.nextLine();
				tree_nodes[j] = str.split(" ")[1].charAt(0);
			}
			System.out.print("#" + i + " ");
			in_order(1);
			System.out.println("");
		}
	}
	public static void in_order(int index)
	{
		if(index <= N)
		{
			in_order(index*2);
			System.out.print(tree_nodes[index]);
			in_order(index*2 + 1);
		}
		else
			return;
	}
}

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Treasure_King_Taehyung_7829 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_7829.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int P, j;
		for(int i = 1; i <= T; i++)
		{
			P = scan.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(j = 0; j < P; j++)
			{
				arr.add(scan.nextInt());
			}
			arr.sort(null);
			System.out.println("#" + i + " " + arr.get(0)*arr.get(arr.size()-1));
		}
	}
}
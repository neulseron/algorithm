import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Password_Day10_1234 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1234.txt"));
		Scanner scan = new Scanner(System.in);
		int length, index;
		String str, answer;
		int j;
		for(int i = 1; i <= 10; i++)
		{
			answer = "";
			ArrayList<Character> arr = new ArrayList<Character>();
			length = scan.nextInt();
			str = scan.next();
			for(j = 0; j < length; j++)
			{
				arr.add(str.charAt(j));
			}
			index = 0;
			while(true)
			{
				if(index == arr.size() - 1)
					break;
				if(arr.get(index) == arr.get(index + 1))
				{
					arr.remove(index);
					arr.remove(index);
					if(index == 0)
						index = 0;
					else
						index -= 1;
				}
				else
					index += 1;
			}
			for(j = 0; j < arr.size(); j++)
				answer += arr.get(j);
			System.out.println("#" + i + " " + answer);
		}
	}
}

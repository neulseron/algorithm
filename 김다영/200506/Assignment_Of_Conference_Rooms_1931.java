package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment_Of_Conference_Rooms_1931 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] time = new int[N][2];
		int i, end_time;
		int answer = 1;
		for(i = 0; i < N; i++)
		{
			time[i][0] = scan.nextInt();
			time[i][1] = scan.nextInt();
		}
		Arrays.sort(time,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		end_time = time[0][1];
		for(i = 1; i < N; i++)
		{
			if(time[i][0] < end_time)
				continue;
			answer += 1;
			end_time = time[i][1];
		}
		System.out.println(answer);
	}
}
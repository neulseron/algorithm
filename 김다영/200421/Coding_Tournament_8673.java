import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Coding_Tournament_8673 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_8673.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int t = 1; t <= TC; t++) {
            int answer = 0;
            int K = scan.nextInt();
            for (int i = 0; i < Math.pow(2, K); i++)
                q.add(scan.nextInt());
            for (int i = K - 1; i >= 0; i--) {
                for (int j = 0; j < Math.pow(2, i); j++) {
                    int a = q.poll();
                    int b = q.poll();
                    answer += Math.abs(a - b);
                    if (a < b)   
                    	q.add(b);
                    else 
                    	q.add(a);
                }
            }
            System.out.println("#" + t + " " + answer);
            q.clear();
        }
    }
}
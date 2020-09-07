package programming.programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class KAKAO_BLIND_2019_후보키 {
	static int[] numbers;
	static int reLen, len;
	static ArrayList<ArrayList<Integer>> keyList;

	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		int answer = solution(relation);
		System.out.println(answer);
	}
	
	private static int solution(String[][] relation) {
		int answer = 0;
		reLen = relation.length; // 튜플 수
		len = relation[0].length; // 칼럼 수
		keyList = new ArrayList<>();
		for(int i = 1; i <= len; i++) { // 칼럼별로
			numbers = new int[i];
			comb(0,0,i, relation);
		}
		answer = keyList.size();
		return answer;
	}
	
	private static void comb(int start, int cnt, int R, String[][] relation) {
		if(cnt == R) {
			// 확정된 후보키가 일부로 포함된 것인지 (최소성 확인)
			ArrayList<Integer> tmpList = new ArrayList<>();
			for(int i = 0; i < R; i++)
				tmpList.add(numbers[i]);
			
			for(ArrayList<Integer> l : keyList) {
				if(tmpList.containsAll(l)) return;
			}
			
			// 유일성 체크
			HashSet<String> set = new HashSet<>();
			for(int i = 0; i < reLen; i++) {
				String tmp = "";
				for(int j = 0; j < R; j++)
					tmp += relation[i][numbers[j]];
				set.add(tmp);
			}
			// 유일성 만족
			if(set.size() == reLen) {
				keyList.add(tmpList);
			}
			return;
		}
		for(int i = start; i < len; i++) {
			numbers[cnt] = i;
			comb(i+1, cnt+1, R, relation);
		}
	}
}
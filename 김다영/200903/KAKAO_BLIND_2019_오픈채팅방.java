package programming.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KAKAO_BLIND_2019_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		for(String s : result) {
			System.out.println(s);
		}
	}
	private static String[] solution(String[] record) {
		String[] answer;
		ArrayList<User> list = new ArrayList<>(); // 실행 결과 저장
		HashMap<String, String> user = new HashMap<>(); // 유저 id, nickname
		StringTokenizer st;
		String uid, nickName;
		for(String s : record) {
			st = new StringTokenizer(s);
			switch(st.nextToken()) {
				case "Enter":
					uid = st.nextToken();
					nickName = st.nextToken();
					user.put(uid, nickName);
					list.add(new User(uid, 0));
					break;
				case "Leave":
					uid = st.nextToken();
					list.add(new User(uid, 1));
					break;
				case "Change":
					uid = st.nextToken();
					nickName = st.nextToken();
					user.put(uid, nickName);
					break;
			}
		}
		// 문자열로 변경
		answer = new String[list.size()];
		int i = 0;
		for(User u : list) {
			if(u.type == 0)
				answer[i] = user.get(u.uid) + "님이 들어왔습니다.";
			else
				answer[i] = user.get(u.uid) + "님이 나갔습니다.";
			i++;
		}
		return answer;
	}
	static class User{
		private String uid;
		private int type; // 0 : Enter, 1 : Leave
		public User(String uid, int type) {
			this.uid = uid;
			this.type = type;
		}
	}
}
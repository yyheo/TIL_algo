import java.util.HashSet;

public class 영어끝말잇기 {
	static HashSet<String> set;
	
    public static int[] solution(int n, String[] words) {
    	int[] answer = new int[2];
    	int[] cnt = new int[n];
    	set = new HashSet<String>();
    	int idx = 1;
    	// 첫번째 순서는 체크 안해도 됨
    	cnt[0] = 1;
    	set.add(words[0]);
    	for (int i = 1; i < words.length; i++) {
    		cnt[idx]++;
			if(!correct(words[i - 1], words[i])) {
				answer[0] = idx + 1;
				answer[1] = cnt[idx];
				break;
			}
			idx++;
    		// 마지막 사람이 단어 말한 후에는 다시 1번에게
    		if (idx == n) {
    			idx = 0;
    		}
		}
        return answer;
    }
    private static boolean correct(String pre, String cur) {
    	// 이전에 등장했던 단어는 사용할 수 없음
    	if(set.contains(cur)) {
    		return false;
    	}
		// 앞사람이 말한 단어의 마지막문자로 시작하는 단어를 말해야 함
    	if(pre.charAt(pre.length() - 1) != cur.charAt(0)) {
    		return false;
    	}
    	set.add(cur);
		return true;
	}
	public static void main(String[] args) {
    	String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int[] ans = solution(2, words);
		System.out.println(ans[0] + " " + ans[1]);
	}
}

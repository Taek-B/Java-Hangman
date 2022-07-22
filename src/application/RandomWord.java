package application;

import java.util.Random;

/*
 * 랜덤 단어를 생성해주는 클래스
 * https://randomwordgenerator.com/		=> 랜덤단어 가져옴
 * https://www.browserling.com/tools/newlines-to-spaces  => 단어 뒤에 /r/n를 없애주는 사이트
 */
public class RandomWord {

	private String books = "knowledge interaction information marriage requirement negotiation initiative analysis president decision tradition distribution feedback boyfriend industry contract midnight permission computer advertising connection inspector classroom combination shopping revolution possibility newspaper performance property";
	private String[] words = books.split(" "); // 스페이스로 단어들을 분리해서 배열
	private Random random = new Random();
	private String selectWord; // 랜덤으로 선택된 단어
	private char[] characters;

	/* 생성자로 생성시 단어가 선택됨 */
	public RandomWord() {
		selectWord = words[random.nextInt(words.length)]; // 첫번째 단어
		characters = new char[selectWord.length()]; // 단어의 길이만큼 공간을 만듬
	}

	/* 단어배열 words에 있는 모든 단어 출력 */
	public void getWords() {
		for (String word : words) {
			System.out.println(word);
		}
	}

	/* 선택된 한개의 단어 리턴 */
	public String toString() {
		String text = "";

		for (char c : characters) {
//			if(c == '\u0000') { // 처음 상태 공백, null문자 유니코드 (문자열의 null값)
//				text += '_';
//			}else { // 문자를 맞췄을 때
//				text += c;
//			}

			// 삼항연산자
			text += (c == '\u0000') ? '_' : c;
			text += ' '; // 단어를 하나씩 띄워 보기좋게

		}

		System.out.println(selectWord); // 임시 단어를 보여줌
		return text;
	}

	/* 입력된 문자와 같은 문자가 있는지 확인해서 문자배열 characters에 입력 */
	public boolean addGuess(char c) {
		// 선택된 문자열 전체를 확인
		boolean ok = false;
		for (int i = 0; i < selectWord.length(); i++) {
			if (c == selectWord.charAt(i)) {
				characters[i] = c;
				ok = true;
			}
		}
		return ok ? false : true;
	}

	public boolean isCompleted() {
		// 만약에 전체 characters에서 공백 '\u0000'이 없으면 종료
		for (char c : characters) {
			if (c == '\u0000') {
				return false; // 아직 맞출 문자 있음
			}
		}
		// 공백이 하나도 없으면 내려옴
		return true; // 전부 체크해서 완료
	}
}

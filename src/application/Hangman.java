package application;

import java.util.Scanner;

/*
 * 전체 행맨 게임을 실행하는 클래스
 */
public class Hangman {

	private boolean running = true;
	private RandomWord word = new RandomWord();
	private Scanner scan = new Scanner(System.in);

	private int remainTries = 7;
	private char lastGuess;

	public void run() {
		do {
			displayWord(); // 화면에 단어표시
			getUserInput(); // 입력받음
			checkUserInput(); // 맞는지 체크 => 맞을시 running=false
		} while (running); // running이 false가 되면 반복종료
	}

	public void displayWord() {
		// 단어 표시하기
		System.out.println(word.toString()); // 랜덤으로 선택된 단어
	}

	public void getUserInput() {
		// 유저에세 한 문자 입력 요구
		// 입력받은 문자열에서 한 문자를 뽑아서
		// RandomWord 클래스에 전달 (addGuess(문자) 메소드를 만들자)
		System.out.println("한 문자 입력 : ");
		System.out.println("시도횟수 : " + remainTries);
		String guess = scan.nextLine(); // 유저가 입력한 문자열 받음

		// 문자열에서 빼낸 한 문자를 랜덤워드 메서드 addGuess에 입력
		// word.addGuess(guess.charAt(0));

		lastGuess = guess.charAt(0);

	}

	public void checkUserInput() {
		// 체크
		boolean isCorrect = word.addGuess(lastGuess);

		if (isCorrect) {
			if (word.isCompleted()) {
				System.out.println("승리!!");
				System.out.println("시도횟수 : " + remainTries);
				System.out.println("정답은 : " + word.toString());
				running = false; // 반복문 종료
			} else {
				remainTries--;
				if(remainTries==0) {
					System.out.println("Game Over!");
					running = false;
				}
			}

		}
	}

	public void close() {
		scan.close(); // 게임 종료 시 Scanner 닫기
	}
}

package application;

public class App {

	public static void main(String[] args) {
		// 행맨 프로그램 시작
		Hangman game = new Hangman();
		game.run();
		game.close();	// Scanner 닫기
	}

}

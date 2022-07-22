package test;

import java.util.Random;

import application.RandomWord;

/* 테스트 패키지에서 테스트하기 */
public class RandomTest {

	public static void main(String[] args) {
		RandomWord randomWord = new RandomWord();
		// randomWord.getWords();
		// System.out.println(randomWord.toString());
		
		// 랜덤으로 한 단어를 가져오기
		Random ran = new Random();
		String words[] = {"아","뭐","그래","어쩔"};
		for(int i =0; i < 100; i++) {
			int randomIndex = ran.nextInt(words.length); // 5면 0~4까지 랜덤
			System.out.println(words[randomIndex]);
		}
	}

}

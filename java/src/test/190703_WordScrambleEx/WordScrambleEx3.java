package test.WordScrambleEx;

import java.util.Scanner;

public class WordScrambleEx3 {
	/*	
	 * 2019.07.03 WordScrambleEx3
	 * [문제3] 문제2의 예제를 변경해서, 문제를 맞추더라도 프로그램이 종료되지 않고 다음문제를 보여주도록 하세요.
		[실행결과]
		
		Question :IWVE
		Your answer is :ievw
		ievw은/는 정답이 아닙니다. 다시 시도해보세요.
		Question :IWVE
		Your answer is :view
		정답입니다.
		
		Question :HOEP
		Your answer is :hope
		정답입니다.
		
		Question :GNCAEH
		Your answer is :change
		정답입니다.
		
		Question :HECNAG
		Your answer is :q

	 * [출처] [Java1000제]Word Scramble 1 - 단어 맞추기 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
	 */
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };

		while (true) {
			// 코드를 넣어 완성하세요.
			String answer = getAnswer(strArr);
			String question = getScrambledWord(answer);
			// hint : while문을 중첩해서(2개의 while문) 작성하세요.
			String message;
			while (true) {
				System.out.println("Question :" + question);
				System.out.print("Your answer is :");
				
				Scanner scanner = new Scanner(System.in);
				message = scanner.nextLine();
				if ( "Q".equals(message.toUpperCase()) ) {
					break;
				} else if ( answer.equals(message.toUpperCase()) ) {
					System.out.println("정답입니다.");
					break;
				} else {
					System.out.println(message + "은/는 정답이 아닙니다. 다시 시도해보세요.");
				}
			}
			
			if ( "Q".equals(message.toUpperCase()) ) {
				break;
			}
		}
	} // main

	public static String getAnswer(String[] strArr) {
		int idx = (int) (Math.random() * strArr.length);
		return strArr[idx];
	}

	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {

			int idx = (int) (Math.random() * str.length());

			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}

		return new String(chArr);
	} // scramble(String str)
}
/* 문제 원본
      public static void main(String[] args) { 
            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 
            

            // 코드를 넣어 완성하세요.

            // hint : while문을 중첩해서(2개의 while문) 작성하세요.            

      } // main 

      public static String getAnswer(String[] strArr) { 
            int idx = (int)(Math.random()*strArr.length); 
            return strArr[idx]; 
      } 
      
      public static String getScrambledWord(String str) { 
            char[] chArr = str.toCharArray(); 

            for(int i=0;i < str.length();i++) {
                  

                  int idx = (int)(Math.random()*str.length()); 
                  
                  char tmp = chArr[i]; 
                  chArr[i] = chArr[idx]; 
                  chArr[idx] = tmp; 
            } 

            return new String(chArr); 
      } // scramble(String str) 
*/
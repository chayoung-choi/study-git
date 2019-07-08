package study.AAD_ConsoleEx;

import java.util.Scanner;

/*	190707.
 *  이번 문제는 도스창과 같은 콘솔어플리케이션을 만들어보는 것입니다. 도스창 처럼 명령어를 입력하면
	명령어가 실행된 결과를 화면에 보여주는 텍스트 기반의 어플리케이션입니다.(text-based application)

	[문제1] 에제를 실행하면 '>>'와 같은 프롬프트가 나타나서 사용자의 입력을 기다리고,
	        사용자가 입력한 내용을 화면에 출력한다. 만일 사용자가 'q' 또는 'Q'를 입력하면 프로그램을 종료한다.
	        다음의 예제를 완성하세요.
	[실행결과]
	
	>>hello
	hello
	>>help
	help
	>>ok
	ok
	>>q

	[출처] [Java1000제] 콘솔 만들기 1 - 도스창 따라하기 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
 */
public class ConsoleEx1 {
	public static void main(String[] args) {
		while (true) {
			String prompt = ">>";
			System.out.print(prompt);
			/*
			 * 다음과 같은 내용의 코드를 넣으세요.
			 * 1. 화면으로부터 라인단위로 입력받는다. 
			 * - java.util.Scanner클래스 사용
			 * 2. q 또는 Q를 입력하면 실행종료한다.
			 */
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			
			if ( "Q".equalsIgnoreCase(input) ) {
				break;
			}
			
			System.out.println(input);

		} // while(true)
	} // main
}
/*
[원문]
class ConsoleEx1 { 
      public static void main(String[] args) { 
            while(true) { 
                  String prompt = ">>"; 
                  System.out.print(prompt); 
                  

                  

                     다음과 같은 내용의 코드를 넣으세요.                  

                     1. 화면으로부터 라인단위로 입력받는다.  - java.util.Scanner클래스 사용
                     2. q 또는 Q를 입력하면 실행종료한다.

                  


             } // while(true) 
      } // main 
} // class
*/
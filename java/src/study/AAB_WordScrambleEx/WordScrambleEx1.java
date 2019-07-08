package study.AAB_WordScrambleEx;

public class WordScrambleEx1 {
	/*	
	 * 2019.07.03 WordScrambleEx1
	 * [문제1] 다음의 예제를 완성하시오.
	 * getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다. (Math.random()사용)
	 * getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다. (Math.random()사용)
	 * 
	 * [실행결과]
	 * Question:HEPO
	 * Answer:HOPE
	 * [참고]Math.random()을 사용하기 때문에 위의 실행결과와 다를 수 있습니다.
	 * [출처] [Java1000제]Word Scramble 1 - 단어 맞추기 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
	 */
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };

		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);

		System.out.println("Question:" + question);
		System.out.println("Answer:" + answer);
	} // main

	public static String getAnswer(String[] strArr) {
		// 내용을 완성하세요.
		int maxLength = strArr.length;
		int idx = (int)(Math.random() * maxLength);
		return strArr[idx];
	}

	public static String getScrambledWord(String str) {
		// 내용을 완성하세요.
		String[] word = str.split("");
		int maxLength = word.length;
		
		String scrambledWord = "";
		while ( maxLength != scrambledWord.length()) {
			
			int idx = (int)(Math.random() * maxLength);
			if ( !"".equals(word[idx]) ) {
				scrambledWord += word[idx];
				word[idx] = "";
			}
		}
		
		return scrambledWord;
	} // scramble(String str)
	
///////////////////////////////////////////////////////////////////////////////////////
// // 원문제	
//	class WordScrambleEx1 { 
//	      public static void main(String[] args) { 
//	            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 
//
//	            String answer = getAnswer(strArr); 
//	            String question = getScrambledWord(answer); 
//
//	            System.out.println("Question:"+question); 
//	            System.out.println("Answer:"+answer); 
//	      } // main 
//
//	      public static String getAnswer(String[] strArr) { 
//	           // 내용을 완성하세요.
//
//	      } 
//	      
//	      public static String getScrambledWord(String str) { 
//	            // 내용을 완성하세요.
//
//	      } // scramble(String str) 
//	}
}

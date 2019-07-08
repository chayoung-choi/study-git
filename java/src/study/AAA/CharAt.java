package study.AAA;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CharAt {
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date today = new Date();
		String formatDate = sdf.format(today);
		
		System.out.println("today : " + formatDate);
		
		Scanner s = new Scanner(System.in);
//		while (true) {
//			System.out.print(">> ");
//			String input = s.nextLine();
//			
//			if ( "q".equalsIgnoreCase(input) ) {
//				break;
//			} else {
//				char[] charInput = input.toCharArray();
//				System.out.println( ">> charInput : " + charInput.toString());
//			}
//		}
		
		System.out.println("숫자를 입력해주세요");
		int alpa = s.nextInt();
		char calpa = (char)alpa;
			
		System.out.println(calpa);
	}
}

package study.AAE_SungJukEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
	190714.
[문제3] list를 다양한 기준으로 정렬하기 위해 Comaprator를 구현한 클래스를 구현하세요.
       ClassTotalComparator - 반별로 총점이 높은 순에서 낮은 순으로 정렬(반은 오름차순, 총점은 내림차순)
       ClassStudentNo - 반, 번호 순으로 내림차순 정렬
[실행결과]
[반별 총점높은 순으로 정렬]
이름    반     번호    국어    수학    영어    총점
====================================================
자바짱  1       1       100     100     100     300  <------ 1반 1등
킹왕짱  1       2       100     60      90      250
최고수  1       3       100     80      60      240
이원구  2       2       90      90      90      270  <------ 2반 1등
일지매  2       3       70      80      100     250
변강쇠  2       4       80      80      85      245
홍길동  2       1       50      80      100     230
남궁성  3       2       100     100     100     300  <------ 3반 1등
왕자바  3       1       90      100     80      270
자바왕  3       3       70      100     100     270
====================================================

[반, 번호 순으로 정렬]
이름    반     번호    국어    수학    영어    총점
====================================================
자바짱  1       1       100     100     100     300
킹왕짱  1       2       100     60      90      250
최고수  1       3       100     80      60      240
홍길동  2       1       50      80      100     230
이원구  2       2       90      90      90      270
일지매  2       3       70      80      100     250
변강쇠  2       4       80      80      85      245
왕자바  3       1       90      100     80      270
남궁성  3       2       100     100     100     300
자바왕  3       3       70      100     100     270
====================================================
[출처] [Java1000제] 성적처리 3 - Comparator를 이용한 정렬 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성

*/
class SungJukEx3 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();

		// 이름, 반, 번호, 국어, 수학, 영어
		list.add(new Student("남궁성", 3, 2, 100, 100, 100));
		list.add(new Student("왕자바", 3, 1, 90, 100, 80));
		list.add(new Student("자바왕", 3, 3, 70, 100, 100));
		list.add(new Student("킹왕짱", 1, 2, 100, 60, 90));
		list.add(new Student("자바짱", 1, 1, 100, 100, 100));
		list.add(new Student("최고수", 1, 3, 100, 80, 60));
		list.add(new Student("홍길동", 2, 1, 50, 80, 100));
		list.add(new Student("일지매", 2, 3, 70, 80, 100));
		list.add(new Student("변강쇠", 2, 4, 80, 80, 85));
		list.add(new Student("이원구", 2, 2, 90, 90, 90));

		System.out.println("[반별 총점높은 순으로 정렬]");
		Collections.sort(list, new ClassTotalComparator()); // 반, 총점 순으로 정렬
		printList(list);

		System.out.println();

		System.out.println("[반, 번호 순으로 정렬]");
		Collections.sort(list, new ClassStudentNoComparator()); // 반, 번호 순으로 정렬
		printList(list);
	}

	public static void printList(List<Student> list) {
		System.out.println("이름\t학년\t반\t국어\t수학\t영어\t총점 ");
		System.out.println("====================================================");

		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("====================================================");
	}
}
/*	// 객체 중복으로 인한 주석처리
class Student implements Comparable<Student> {
	String name = "";
	int classNo = 0;
	int studentNo = 0;
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;

	int total = 0;

	Student(String name, int classNo, int studentNo, int koreanScore, int mathScore, int englishScore) {
		this.name = name;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;

		total = koreanScore + mathScore + englishScore;
	}

	public String toString() {
		return name + "\t" + classNo + "\t" + studentNo + "\t" + koreanScore + "\t" + mathScore + "\t" + englishScore
				+ "\t" + total + "\t";
	}

	public int compareTo(Student obj) {
		return obj.total - this.total;
		// return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬
	}
} // end of class Student

class ClassTotalComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		
		 * 코드를 완성하세요.
		 
		int result = 0;
		int compClass = s1.classNo - s2.classNo;
		if (compClass != 0) {
			result = compClass;
		} else if ( compClass == 0 ) {
			result = s2.total - s1.total;
		}
		return result;
	}
}

class ClassStudentNoComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		
		 * 코드를 완성하세요.
		 
		int result = 0;
		int compClass = s1.classNo - s2.classNo;
		if (compClass != 0) {
			result = compClass;
		} else if ( compClass == 0 ) {
			result = s1.studentNo - s2.studentNo;
		}
		return result;
	}
}*/
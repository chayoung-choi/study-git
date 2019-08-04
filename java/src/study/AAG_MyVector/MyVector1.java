package study.AAG_MyVector;

/*	190804.
객체배열을 기반으로 하는 Vector클래스를 직접 구현해보는 문제 입니다.
[문제1] 다음의 MyVector클래스의 메서드들을 완성하세요.

MyVector(int capacity) - 매개변수 capacity의 값을 용량으로 갖는 객체배열을 생성한다.
MyVector()             - 매개변수 없는 생성자. 기본적으로 용량이 10인 객체배열을 생성한다.
boolean isEmpty()      - 객체배열이 비어있는지 확인하고 비어있으면 true, 그렇지 않으면 false를 반환한다.
int size()             - 객체배열의 저장되어 있는 객체의 개수를 반환한다.
int capacity()         - 객체배열의 용량(배열의 크기)을 반환한다.
[출처] [Java1000제] 객체배열 MyVector 구현하기 1 - 생성자, size() 등 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
*/
public class MyVector1 {
	protected Object[] data = null; // 객체를 담기 위한 객체배열을 선언한다.
	protected int capacity = 0; // 용량(객체배열의 크기)
	protected int size = 0; // 객체배열에 저장된 객체의 개수

	public MyVector1(int capacity) {

		/*
		 * 다음의 코드를 완성하세요.
		 * 1. 지역변수 capacity의 값이 0보다 작으면, IllegalArgumentExcepton을 발생시킨다.
		 * 2. 지역변수 capacity의 값을 인스턴스변수 capacity에 저장한다.
		 * 3. 지역변수 capacity와 같은 크기의 Object배열을 생성해서 객체배열 data에 저장한다.
		 */
		if (capacity < 0) {
			new IllegalArgumentException();
		}
		this.capacity = capacity;
		this.size = capacity;
		this.data = new Object[size];
	}

	public MyVector1() {

		// 크기를 지정하지 않으면 크기를 10으로 한다.
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. 매개변수가 없는 생성자를 통해 MyVector를 생성한다면,
		 * 용량(capacity)가 10이 되도록 한다.
		 * 매개변수가 있는 생성자 MyVector(int capacity)를 사용하세요.
		 */

	}

	public boolean isEmpty() {

		// MyVector가 비어있는지 확인한다.

	}

	public int capacity() {

		// MyVector의 용량(크기)를 반환한다.

	}

	public int size() {
		// MyVector에 저장된 객체의 개수를 반환한다.

	}
} // class MyVector

class MyVectorEx1 {
	public static void main(String args[]) {
		MyVector1 v = new MyVector1();

		System.out.println("size:" + v.size());
		System.out.println("capacity:" + v.capacity());
		System.out.println("isEmpty:" + v.isEmpty());
	}
}
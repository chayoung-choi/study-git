package study.AAG_MyVector;

/*	190805.
[문제2] 다음의 MyVector클래스의 메서드들을 완성하세요.

void ensureCapacity(int minCapacity) - 객체배열이 최소한 지정된 용량을 확보하도록 한다.
void setCapacity(int newCapacity)     - 객체배열의 용량을 지정된 용량(newCapacity)으로 변경한다.
boolean add(Object obj)                   - 객체배열에 객체(obj)를 저장한다.
Object get(int index)                         - 객체배열에 저장된, index번째의 객체를 반환한다.
Object set(int index, Object obj)        - 객체배열의 index번째의 위치에 객체(obj)를 저장하고, 기존의 객체를 반환한다.
[출처] [Java1000제] 객체배열 MyVector 구현하기 2 - add(), get(), set() (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
*/
/*
[실행결과]
AAA
BBB
CCC
size:3
capacity:4
isEmpty:false
aaa
BBB
CCC
*/
class MyVector2 {
	protected Object[] data = null; // 객체를 담기 위한 객체배열을 선언한다.
	protected int capacity = 0; // 용량
	protected int size = 0; // 크기

	public MyVector2(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("유효하지 않은 값입니다. :" + capacity);
		this.capacity = capacity;
		data = new Object[capacity];
	}

	public MyVector2() {
		this(10); // 크기를 지정하지 않으면 크기를 10으로 한다.
	}

	public boolean isEmpty() { // MyVector가 비어있는지 확인한다.
		return size == 0;
	}

	public int capacity() { // MyVector의 용량(크기)를 반환한다.
		return capacity;
	}

	public int size() { // MyVector에 저장된 객체의 개수를 반환한다.
		return size;
	}

	public void ensureCapacity(int minCapacity) {
		int newCapacity = capacity;

		/*
		 * 다음의 코드를 완성하세요.
		 * 1. minCapacity가 capacity보다 크면 newCapacity의 값을 두배로 한다.
		 * (사실 반드시 2배이어야 할 필요는 없다. 적절한 비율로 크기를 늘려주기 위한 것임)
		 * 2. 그래도 minCapacity가 newCapacity보다 크면,
		 * minCapacity의 값을 newCapacity에 저장한다.
		 * 3. setCapacity()를 호출해서 객체배열의 크기가 newCapacity가 되도록 한다.
		 */
		if ( minCapacity > capacity ) {
			newCapacity = newCapacity*2;
		}
		if ( minCapacity > newCapacity ) {
			newCapacity = minCapacity;
		}
		setCapacity(newCapacity);

	}

	public void setCapacity(int newCapacity) {
		if (this.capacity == newCapacity) {
			return;
		}
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. newCapacity 크기의 객체배열을 새로 만든다.
		 * 2. 기존의 객체배열(data)의 내용을 새로운 객체배열에 복사한다.
		 * (System.arraycopy()사용)
		 * 3. data가 새로 생성된 객체배열을 참조하도록 한다.
		 * 4. capacity의 값을 newCapacity로 변경한다.
		 */
		Object[] newDate = new Object[newCapacity];
		System.arraycopy(data, 0, newDate, 0, newCapacity);
		data = newDate;
		this.capacity = newCapacity;
	}

	public boolean add(Object obj) {
		// 새로운 객체를 저장하기 전에 저장할 공간을 확보한 후에 객체를 추가해야한다.
		/*
		 * 코드를 완성하세요.
		 */

	}

	public Object get(int index) {
		/*
		 * 코드를 완성하세요.
		 */

	}

	public Object set(int index, Object obj) {
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. index가 size보다 크면 ArrayIndexOutOfBoundsException을 발생시킨다.
		 * 2. 객체배열 data의 index번째 값을 임시로 저장한다.
		 * 3. 새로운 객체(obj)를 객체배열 data의 index번째 값에 저장한다.
		 * 4. 임시로 저장했던 기존 객체를 반환한다.
		 */

	}

} // class MyVector

class MyVectorEx2 {
	public static void main(String args[]) {
		MyVector2 v = new MyVector2(2);

		v.add("AAA");
		v.add("BBB");
		v.add("CCC");

		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}

		System.out.println("size:" + v.size());
		System.out.println("capacity:" + v.capacity());
		System.out.println("isEmpty:" + v.isEmpty());

		v.set(0, "aaa");

		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}

	} // main
}
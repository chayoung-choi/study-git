package study.AAG_MyVector;

/*[문제4] 다음의 MyVector4클래스의 메서드들을 완성하세요.
void add(int index, Object obj)   - 객체배열의 지정된 위치(index)에 객체(obj)를 추가한다.
Object remove(int index)        - 객체배열에서 index번째(index는 0부터 시작)에 있는 객체를 삭제한다.
boolean remove(Object obj)   - 객체배열에서 지정된 객체(obj)를 찾아서 삭제한다. 삭제에 성공하면 true, 실패하면 false
void clear()                          - 객체배열을 비운다.
Object[] toArray()                 -  객체배열을 복사해서 반환한다.
String toString()                    - 객체배열에 저장된 모든 객체를 출력한다.(모든 객체의 toString()을 호출한다.)

[예제MyVector4Ex4.java]

[실행결과]
AAA,BBB,EEE,CCC,DDD,
size:5
capacity:8
isEmpty:false

[AAA,EEE,DDD]
size:3
capacity:8
isEmpty:false

[]
size:0
capacity:8
isEmpty:true

[출처] [Java1000제] 객체배열 MyVector4 구현하기 4 - add(), remove(), toArray() 등 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성*/
class MyVector4 {
	protected Object[] data = null; // 객체를 담기 위한 객체배열을 선언한다.
	protected int capacity = 0; // 용량
	protected int size = 0; // 크기

	public MyVector4(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("유효하지 않은 값입니다. :" + capacity);
		this.capacity = capacity;
		data = new Object[capacity];
	}

	public MyVector4() {
		this(10); // 크기를 지정하지 않으면 크기를 10으로 한다.
	}

	public boolean isEmpty() { // MyVector4가 비어있는지 확인한다.
		return size == 0;
	}

	public int capacity() { // MyVector4의 용량(크기)를 반환한다.
		return capacity;
	}

	public int size() { // MyVector4에 저장된 객체의 개수를 반환한다.
		return size;
	}

	public void ensureCapacity(int minCapacity) {
		int newCapacity = capacity;

		if (minCapacity > capacity) {
			newCapacity = capacity * 2;
		}

		if (minCapacity > newCapacity) {
			newCapacity = minCapacity;
		}

		setCapacity(newCapacity);
	}

	public void setCapacity(int newCapacity) {
		if (this.capacity == newCapacity)
			return;

		Object[] tmp = new Object[newCapacity];
		System.arraycopy(data, 0, tmp, 0, size);

		this.data = tmp;
		this.capacity = newCapacity;
	}

	public boolean add(Object obj) {
		// 새로운 객체를 저장하기 전에 저장할 공간을 확보한다.
		ensureCapacity(size + 1);
		data[size++] = obj;
		return true;
	}

	public Object get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		return data[index];
	}

	public Object set(int index, Object obj) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(index);

		Object oldValue = data[index];
		data[index] = obj;
		return oldValue;
	}

	public int indexOf(Object obj, int index) {
		if (obj == null) {
			for (int i = index; i < size; i++) {
				if (data[i] == null)
					return i;
			} // for
		} else {
			for (int i = index; i < size; i++) {
				if (obj.equals(data[i]))
					return i;
			} // for
		}

		return -1;
	}

	public int lastIndexOf(Object obj, int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(index + " >= " + size);

		if (obj == null) {
			for (int i = index; i >= 0; i--)
				if (data[i] == null)
					return i;
		} else {
			for (int i = index; i >= 0; i--)
				if (obj.equals(data[i]))
					return i;
		}

		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj, 0) >= 0;
	}

	public int indexOf(Object obj) {
		// 찾기 시작할 위치(index)를 지정하지 않으면 처음부터 찾는다.
		return indexOf(obj, 0);
	}

	public int lastIndexOf(Object obj) {
		// 찾기 시작할 위치(index)를 지정하지 않으면 끝부터 찾는다.
		return lastIndexOf(obj, size - 1);
	}

	public void add(int index, Object obj) {

		/*
		 * 다음의 코드를 완성하세요.
		 * 1. index의 값이 size보다크면, ArrayIndexOutOfBoundsException
		 * 2. ensureCapacity()를 호출해서 새로운 객체가 저장될 공간을 확보한다.
		 * 3. 객체배열에서 index위치의 객체와 이후의 객체들을 한칸씩 옆으로 이동한다.
		 * (System.arraycopy()사용)
		 * 4. 객체배열의 index위치에 새로운 객체(obj)를 저장한다.
		 * 5. size의 값을 1 증가시킨다.
		 */
		if (index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		ensureCapacity(size+1);
		
		System.arraycopy(data, index, data, index+1, size-index);
		data[index] = obj;
		size++;
	}

	public Object remove(int index) {
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. index가 배열의 범위를 벗어나는지 체크하고, 벗어나면 IndexOutOfBoundsException를 발생시킨다.
		 * 2. 삭제하고자하는 데이터를 oldObj에 저장한다.
		 * 3. 삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해 빈자리를 채워준다.
		 * 4. 마지막 데이터를 null로 한다. 배열은 0 부터 시작하므로 마지막 요소는 index가 size-1이다. 
		 * 5. size의 값을 1 감소시킨다.
		 * 6. oldObj를 반환한다.
		 */
		Object oldObj = null;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}

		oldObj = data[index];

		if (index != size - 1) {
			System.arraycopy(data, index + 1, data, index, size - index - 1);
		}
		data[size - 1] = null;
		size--;
		return oldObj;

	}

	public boolean remove(Object obj) {

		/*
		 * 다음의 코드를 완성하세요.
		 * 1. 반복문을 이용해서 객체배열의 모든 요소와 obj가 일치하는지 확인한다.
		 * 1.1 일치하면 remove(int index)를 호출해서 삭제하고 true를 반환한다.
		 * 1.2 일치하는 것을 찾지 못하면, false를 반환한다.
		 */
		for (int i = 0; i < size; i++) {
			if (obj.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void clear() {
		/*
		 * 코드를 완성하세요.
		 */
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}

		size = 0;
	}

	public Object[] toArray() {
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. 객체배열 data와 같은 크기의 객체배열을 생성한다.
		 * 2. 배열의 내용을 복사한다. (System.arraycopy()사용)
		 * 3. 생성한 객체배열을 반환한다.
		 */
		Object[] newDate = new Object[size];
		
		System.arraycopy(data, 0, newDate, 0, size);
		
		return newDate;
	}

	public String toString() {
		/*
		 * 다음의 코드를 완성하세요.
		 * 1. StringBuffer를 생성한다.
		 * 2. 반복문과 get(int i)를 사용해서 배열의 모든 요소에 접근해서 toString()을 호출해서 sb에 저장한다.
		 * 3. sb를 String으로 변환해서 반환한다.
		 */
		StringBuffer sb = new StringBuffer(100);

		sb.append("[");

		for (int i = 0; i < size; i++) {
			if (i != 0)
				sb.append(",");
			sb.append(get(i).toString());
		}

		sb.append("]");

		return sb.toString();
	}

} // class MyVector4

class MyVectorEx4 {
	public static void main(String args[]) {
		MyVector4 v = new MyVector4(2);

		v.add("AAA");
		v.add("BBB");
		v.add("CCC");
		v.add("DDD");
		v.add(2, "EEE");

		Object[] objArr = v.toArray();

		for (int i = 0; i < objArr.length; i++) {
			System.out.print(v.get(i) + ",");
		}
		System.out.println();

		System.out.println("size:" + v.size());
		System.out.println("capacity:" + v.capacity());
		System.out.println("isEmpty:" + v.isEmpty());
		System.out.println();

		v.remove(1); // BBB를 삭제
		v.remove("CCC");

		System.out.println(v); // System.out.println(v.toString());
		System.out.println("size:" + v.size());
		System.out.println("capacity:" + v.capacity());
		System.out.println("isEmpty:" + v.isEmpty());
		System.out.println();

		v.clear();
		System.out.println(v);
		System.out.println("size:" + v.size());
		System.out.println("capacity:" + v.capacity());
		System.out.println("isEmpty:" + v.isEmpty());
	} // main
}
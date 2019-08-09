package study.AAG_MyVector;

/*	190809.
 * [문제3] 다음의 MyVector3클래스의 메서드들을 완성하세요.
boolean contains(Object obj)           - 지정된 객체(obj)가 객체배열에 존재하는지 확인한다. 있으면 true, 없으면 false
int indexOf(Object obj)                - 지정된 객체의 위치(index)를 찾아서 반환한다. 객체배열에 없으면 -1을 반환
int lastIndexOf(Object obj)            - 지정된 객체의 위치(index)를 찾아서 반환한다. 객체배열에 없으면 -1을 반환
int indexOf(Object obj, int index)     - 지정된 객체를 지정한 위치(index)부터 찾기 시작한다. 객체배열에 없으면 -1을 반환
int lastIndexOf(Object obj, int index) - 지정된 객체를 지정한 위치(index)부터 찾기 시작한다. 객체배열에 없으면 -1을 반환(역순으로 찾기 시작한다.)
[출처] [Java1000제] 객체배열 MyVector3 구현하기 3 - indexOf(), contains() 등 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) |작성자 남궁성
*/
/*[실행결과]
0:AAA
1:BBB
2:CCC
3:BBB
indexOf BBB:1
lastIndexOf BBB:3
contains BBB:true
*/
class MyVector3 { 
    protected Object[] data = null;   // 객체를 담기 위한 객체배열을 선언한다. 
    protected int capacity = 0;       // 용량 
    protected int size = 0;           // 크기 

    public MyVector3(int capacity) { 
          if (capacity < 0) 
                throw new IllegalArgumentException("유효하지 않은 값입니다. :"+ capacity); 
          this.capacity = capacity; 
          data = new Object[capacity];             
    } 

    public MyVector3() { 
          this(10);             // 크기를 지정하지 않으면 크기를 10으로 한다. 
    } 

    public boolean isEmpty() { // MyVector3가 비어있는지 확인한다. 
          return size==0; 
    } 

    public int capacity() { // MyVector3의 용량(크기)를 반환한다. 
          return capacity; 
    } 

    public int size() {             // MyVector3에 저장된 객체의 개수를 반환한다. 
          return size; 
    } 

    public void ensureCapacity(int minCapacity) { 
          int newCapacity = capacity; 

          if(minCapacity > capacity) { 
                newCapacity = capacity * 2; 
          } 

          if(minCapacity > newCapacity) { 
                newCapacity = minCapacity; 
          } 

          setCapacity(newCapacity); 
    } 

    public void setCapacity(int newCapacity) { 
          if(this.capacity==newCapacity) return; 

          Object[] tmp = new Object[newCapacity]; 
          System.arraycopy(data,0, tmp, 0, size); 

          this.data = tmp; 
          this.capacity = newCapacity; 
    } 
    
    public boolean add(Object obj) { 
          // 새로운 객체를 저장하기 전에 저장할 공간을 확보한다. 
          ensureCapacity(size+1); 
          data[size++] = obj; 
          return true; 
    } 

    public Object get(int index) { 
          if(index < 0 || index >= size) 
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

          /*
               다음의 코드를 완성하세요.
               1. 넘겨받은 객체(obj)가 null이면,
                  1.1 반복문을 이용해서 객체배열(data)에서 null인 것을 찾아서 그 위치를 반환한다.
                       (검색순서는 index부터 시작해서 증가하는 방향)
               2. 넘겨받은 객체(obj)가 null이 아닌 경우에는
                  2.1 equals를 이용해서 같은 객체가 있는지 찾아서 그 위치를 반환한다.                
                       (검색순서는 index부터 시작해서 증가하는 방향)
               3. 못찾으면 -1을 반환한다.
          */
    	if (obj == null) {
    		for (int i=index; i<size; i++) {
    			if (data[i] == null) {
    				return i;
    			}
    		}
    	} else {
    		for (int i=index; i<size; i++) {
    			if (data[i].equals(obj)) {
    				return i;
    			}
    		}
    		
    	}
    	return -1;
    } 

    public int lastIndexOf(Object obj, int index) {

          /*
              다음의 코드를 완성하세요.
               1. index의 값이 size보다 같거나 크면, IndexOutOfBoundsException을 발생시킨다.
               2. 넘겨받은 객체(obj)가 null이면,
                  2.1 반복문을 이용해서 객체배열(data)에서 null인 것을 찾아서 그 위치를 반환한다.
                       (검색순서는 index부터 시작해서, index값을 감소시켜서 객체배열의 0번째까지 )
               3. 넘겨받은 객체(obj)가 null이 아닌 경우에는
                  3.1 equals를 이용해서 같은 객체가 있는지 찾아서 그 위치를 반환한다.                
                       (검색순서는 index부터 시작해서, index값을 감소시켜서 객체배열의 0번째까지 )
               4. 못찾으면 -1을 반환한다.
          */
    } 

    public boolean contains(Object obj) {

         /*
            코드를완성하세요. indexOf(Object obj, int index)를 사용
         */
    	return indexOf(obj, 0) > -1;
    } 

    public int indexOf(Object obj) { 
          // 찾기 시작할 위치(index)를 지정하지 않으면 처음부터 찾는다. 
         /*
            코드를완성하세요. indexOf(Object obj, int index)를 사용
         */
    	return indexOf(obj, 0);
    } 

    public int lastIndexOf(Object obj) { 
          // 찾기 시작할 위치(index)를 지정하지 않으면 끝부터 찾는다. 
         /*
            코드를완성하세요. lastIndexOf(Object obj, int index)를 사용
         */
    	return lastIndexOf(obj, size);
    } 

} // class MyVector3 

class MyVectorEx3 { 
    public static void main(String args[]) { 
          MyVector3 v = new MyVector3(2); 

          v.add("AAA"); 
          v.add("BBB"); 
          v.add("CCC"); 
          v.add("BBB"); 

          for(int i=0; i < v.size();i++) { 
                System.out.println(i+":"+v.get(i)); 
          } 

          System.out.println("indexOf BBB:"+v.indexOf("BBB")); 
          System.out.println("lastIndexOf BBB:"+v.lastIndexOf("BBB")); 
          System.out.println("contains BBB:"+v.contains("BBB")); 

    } // main 
}

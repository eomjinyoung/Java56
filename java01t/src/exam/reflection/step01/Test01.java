package exam.reflection.step01;

import java.lang.reflect.Method;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // 1. 인스턴스 생성 : 보통
    MyClass p = new MyClass();
    p.result = 20;
    p.plus(10);
    System.out.println(p.result);
    
    // 2. 인스턴스 생성 : Class 객체 이용
    Class clazz = Class.forName("exam.reflection.step01.MyClass");
    MyClass p2 = (MyClass)clazz.newInstance();
    p2.result = 20;
    
    // 3. Reflection API를 이용하여 클래스 내부의 정보를 추출한다.
    // => getMethod("메서드이름", 파라미터 타입) : 클래스의 메서드 정보를 추출한다.
    Method method = clazz.getMethod("plus", int.class);
    
    // 4. Reflection API를 이용하여 메서드 호출
    method.invoke(p2, 40);
    
    System.out.println(p2.result);
    
    

  }

}
